import React, { useEffect, useState } from 'react'
import './QuestionPage.scss'
import axios from 'axios';

const QuestionPage = () => {
  const [question, setQuestion] = useState('예시 질문지');
  useEffect(() => {
    // axios.get('http://localhost:5000/question')
    // .then(function (response) {}
    // .catch(function (error) {console.log(error)})

  }, [question])

  const onSubmithandler = (e) => {
    e.preventDefault();
    // axios.post('http://localhost:5000/question', {}).then
  }

  return (
    <div className='main-container'>
      <div className='question-container'>
        <div className='question'>{question}</div>
        <form className='question-form' onSubmit={onSubmithandler}>
          <button className='question-box' type='submit'>
            dsa
          </button>
          <button className='question-box' type='submit'>
            dsa
          </button>
        </form>
      </div>
    </div>
  )
}

export default QuestionPage
