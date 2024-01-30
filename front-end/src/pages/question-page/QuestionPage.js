import React, { useEffect, useState } from 'react'
import './QuestionPage.scss'
import axios from 'axios';
import { useLocation } from 'react-router-dom';

const QuestionPage = () => {
  // const location = useLocation();
  // const value = location.state.value;

  const [answer, setAnswer] = useState([]);
  useEffect(() => {
    // axios.get('http://localhost:5000/question')
    // .then(function (response) {}
    // .catch(function (error) {console.log(error)})

  }, [answer])

  const onSubmithandler = (e) => {
    e.preventDefault();
    // axios.post('http://localhost:5000/question', {}).then
  }

  return (
    <div className='question-container'>
      <div className='question-box'>
        <p className='question-title'>피자 무료 쿠폰이 생겼다!!</p>
        <button className='question-answer-btn'>
          <p>
            피자는 무조건 파티파티지!
          </p>
          <p className='question-answer-maintitle'>
            친구들이랑 먹는다.
          </p>
        </button>
        <button className='question-answer-btn'>
          <p>
            혼자 먹는게 최고야!
          </p>
          <p className='question-answer-maintitle'>
            혼자 먹는다.
          </p>
        </button>
      </div>
    </div>
  )
}

export default QuestionPage
