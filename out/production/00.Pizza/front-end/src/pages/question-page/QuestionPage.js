import React, { useEffect, useState } from 'react'
import './QuestionPage.scss'

const QuestionPage = ({ UUID }) => {
  const [question, setQuestion] = useState('');
  useEffect(() => {
    // axios.get('http://localhost:5000/question', {
    //  
    // }).then(r => r);

  }, [question])

  const onSubmithandler = (e) => {
    e.preventDefault();
    // axios.post('http://localhost:5000/question', {}).then
  }

  return (
    <div className='question-maincontainer'>
      <div className='question-block'>
        <p>{question}</p>
        <form onSubmit={onSubmithandler}>

          <button className='question-box' type='submit'>
            {/* {first_question} */}
          </button>

          <button className='question-box' type='submit'>
            {/* {second_question} */}
          </button>
          {/*  map 메소드로 변호나해보기  */}
        </form>
      </div>
    </div>
  )
}

export default QuestionPage
