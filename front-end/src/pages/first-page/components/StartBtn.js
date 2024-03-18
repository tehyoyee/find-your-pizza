import React from 'react'
import './StartBtn.scss'
import { useNavigate } from 'react-router-dom'

const StartBtn = () => {
  const navigate = useNavigate();

  const onClickHandler = async (e) => {
    e.preventDefault();
    try {
      navigate('question');
    } catch (e) {
      console.error(e);
    }
  }

  return (
    // git push --force
    <button className='btn yellow' onClick={onClickHandler}>시작하기</button>
  )
}

export default StartBtn