import React from 'react'
import '../../pages/first-page/FirstPage.scss'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import styled, { keyframes } from 'styled-components'

const ImageSrc = '../../Image/pizzaIcon.png';

const getRandomValue = (max) => `${Math.floor(Math.random() * max)}px`;

const snowAnimation = keyframes`
  0% {
    transform: translateY(-100vh) rotate(0deg);
  }
  100% {
    transform: translateY(100vh) rotate(360deg);
  }
`;

const Snow = styled.div`
  top: ${props => props.top};
  left: ${props => props.left};
  width: 30px;
  height: 30px;
  
  background-image: url(${ImageSrc});
  background-size: contain; /* 이미지 크기에 맞게 조정 */
  background-repeat: no-repeat; /* 이미지 반복 없음 */
  z-index: -1;
  position: absolute;
  z-index: 0;
  animation: ${snowAnimation} ${props => props.animationDuration}s linear infinite;
`;




const FirstPagaComponent = () => {

  const navigate = useNavigate();
  const onStartBtn = async () => {
    try {
      const response = await axios.get('/question')
      console.log(response);
      navigate('/question', { state: { value: response.data } })
    } catch (e) {
      console.log(e);
    }
  }

  const snowflakes = Array.from({ length: 15 }).map((_, index) => {
    const top = getRandomValue(window.innerHeight);
    const left = getRandomValue(window.innerWidth);
    const animationDuration = Math.random() * 15 + 15;
    return (
      <Snow key={index} top={top} left={left} animationDuration={animationDuration} />
    );
  });
  return (
    <div className="main-container">
      {snowflakes}
      <img className='test-img' src="../../Image/pizzaBoy.png" alt="피자뽀이" />
      <div className="main-top">
        <p className="main-title">내가 만약 <span>피자</span>라면?</p>
        <img className='main-title-img' src="../../Image/pizzaBoy.png" alt="피자뽀이" />
        <button
          className='start-btn'
          onClick={onStartBtn}
        >시작하기</button>
      </div>
      <div className='main-bottom'>
        <img className='main-bottom-img' src="../../Image/djSimpson.png" alt="피자뽀이" />
      </div>
    </div>
  )
}

export default FirstPagaComponent
