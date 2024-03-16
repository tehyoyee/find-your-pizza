import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import SkeletonBtn from "./components/SkeletonBtn";
import "./QuestionPage.scss";
import axios from "axios";

const QuestionPage = () => {
  const navigate = useNavigate();
  const [uuid, setUuid] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [cookies, setCookie] = useCookies(["uuid"]);

  const [survey, setSurvey] = useState([]); // 질문지
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
          domain: '.find-your-pizza.site',
          path: '/',
          httpOnly: false,
          secure: true,
          maxAge: 36000,
          sameSite: 'none'
        });
        setCookie('uuid', uuidresponse.data.uuid, {
          domain: `www${process.env.COOKIE_DOMAIN}`,
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
  };

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
        // <LoadingPage />
        <div className="question-container">
          <div className="question-box">
            {survey.map((s, index) => {
              if (index === currentQuestionIndex) {
                return (
                  <>
                    <p key={s.id} className="question-title">{s.questionTitle}</p>
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
