import React, { useEffect, useState } from "react";
import LoadingPage from "../loading-page/LoadingPage";
import { useNavigate } from "react-router-dom";

import "./QuestionPage.scss";
import axios from "axios";
// import { useLocation } from 'react-router-dom';

const QuestionPage = () => {
  // const location = useLocation();
  // const value = location.state.value;
  const [isLoading, setIsLoading] = useState(false);
  const [answer, setAnswer] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    // 초기 데이터 로드 관련 로직
  }, []);

const onAnswerSelect = (selectedAnswer) => {
  setAnswer(selectedAnswer);
  onSubmithandler();
};

  const onSubmithandler = async () => {
    // e.preventDefault();
    setIsLoading(true);

    try {
      const response = await axios.post(
        "http://localhost:5000/submit-answers",
        { answer: answer }
      );
      navigate("/result", { state: { results: response.data } });
    } catch (error) {
      console.log(error);
    // } finally {
    //   setIsLoading(false);
    }

    setTimeout(() => {
      navigate('/result');
      // navigate('/result-page', { state: { title: "결과 제목", content: "결과 내용", imageUrl: "/path/to/image.png" } });
      setIsLoading(false);
    }, 2000);
  };

  if (isLoading) {
    return <LoadingPage />;
  }
  // const [answer, setAnswer] = useState([]);
  // useEffect(() => {
  //   // axios.get('http://localhost:5000/question')
  //   // .then(function (response) {}
  //   // .catch(function (error) {console.log(error)})

  // }, [answer])

  // const onSubmithandler = (e) => {
  //   e.preventDefault();
  //   // axios.post('http://localhost:5000/question', {}).then
  // }

  return (
    <div className="question-container">
      <div className="question-box">
        <p className="question-title">피자 무료 쿠폰이 생겼다!!</p>
        <button className="question-answer-btn" onClick={() => onAnswerSelect('party')}>
          <p>피자는 무조건 파티파티지!</p>
          <p className="question-answer-maintitle">친구들이랑 먹는다.</p>
        </button>
        <button className="question-answer-btn" onClick={() => onAnswerSelect('alone')}>
          <p>혼자 먹는게 최고야!</p>
          <p className="question-answer-maintitle" onSubmit={onSubmithandler}>
            혼자 먹는다.
          </p>
        </button>
      </div>
    </div>
  );
};

export default QuestionPage;
