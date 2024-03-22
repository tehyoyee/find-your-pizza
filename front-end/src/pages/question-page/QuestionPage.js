import "./QuestionPage.scss";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import axios from "axios"

import Progress from './components/Progress';

import SkeletonBtn from "./components/SkeletonBtn";

const QuestionPage = () => {
  const navigate = useNavigate();
  const [uuid, setUuid] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [cookies, setCookie] = useCookies(["uuid"]);

  const [progress, setProgress] = useState(0);

  const [survey, setSurvey] = useState([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {},]); // 질문지
  const [answers, setAnswers] = useState([]); // 질문 결과 값
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0); // 현쟤 질문위치
  useEffect(() => {
    const fetchData = async () => {
      try {
        const surveyresponse = await axios.get(`${process.env.REACT_APP_API_URL}/question`);
        const uuidresponse = await axios.get(`${process.env.REACT_APP_API_URL}/uuid`);
        setSurvey(surveyresponse.data);
        setUuid(uuidresponse.data.uuid);
        setCookie('uuid', uuidresponse.data.uuid, {
          domain: `${process.env.REACT_APP_DOMAIN_URL}`,
          path: '/',
          httpOnly: false,
          secure: true,
          maxAge: 36000,
          sameSite: 'none'
        });
        setTimeout(() => setIsLoading(true), 500);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  const handleAnswer = async (selectedAnswer) => {
    console.log('selectedAnswer', selectedAnswer);
    const updatedAnswers = [...answers];
    updatedAnswers[currentQuestionIndex] = selectedAnswer;

    // 다음 질문으로 이동
    if (currentQuestionIndex < survey.length - 1) {
      setCurrentQuestionIndex((prevIndex) => prevIndex + 1);
    } else {
      try {
        await axios.post(
          `${process.env.REACT_APP_API_URL}/question`,
          { answers: updatedAnswers },
          { withCredentials: true }
        );
        navigate("/result");
      } catch (error) {
        console.error(error);
      }
    }
    setAnswers(updatedAnswers);
    const newProgress = Math.floor(((currentQuestionIndex + 1) / survey.length) * 100);
    setProgress(newProgress);
  };
  // const progressCheck = () => {
  //   console.log(progress)
  //   setProgress(prevstate => prevstate + 10)
  // }
  return (
    <>
      {!isLoading ? (
        <div className="question-container">
          <div className="question-box">
            <p className="question-title">질문지 목록!</p>
            <SkeletonBtn />
            <SkeletonBtn />
          </div>
        </div>
      ) : (
        <div className="question-container">
          <div className="question-box">
            {survey.map((s, index) => {
              if (index === currentQuestionIndex) {
                return (
                  <>
                    <p key={s.id} className="question-title">{s.questionTitle}</p>
                    <div className='progress-box' style={{ width: '90%' }}>
                      <Progress value={progress} />
                      <p style={{ fontFamily: 'MaruBuri', fontWeight: 900, textAlign: 'center' }}>{progress}%</p>
                    </div>
                    {/* <button className='question-answer-btn' onClick={progressCheck}>{s.firstQuestion}</button> */}
                    <button className='question-answer-btn' onClick={() => handleAnswer(0)}>{s.firstQuestion}</button>
                    <button className='question-answer-btn' onClick={() => handleAnswer(1)}>{s.secondQuestion}</button>
                  </>
                );
              }
            })}
          </div>
        </div>
      )}
    </>
  );
};

export default QuestionPage;
