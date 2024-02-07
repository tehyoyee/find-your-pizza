import React from 'react'
import '../../pages/first-page/FirstPage.scss'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
<<<<<<< HEAD
import styled from 'styled-components'
=======
import styled, { keyframes } from 'styled-components'
>>>>>>> 3d3e228759e1f99953f9fcd007c35cc4491c0ecd

const ImageSrc = '../../Image/피자뽀이.png';

const getRandomValue = (max) => `${Math.floor(Math.random() * max)}px`;

<<<<<<< HEAD
=======


>>>>>>> 3d3e228759e1f99953f9fcd007c35cc4491c0ecd
const TestStyledComponent = styled.div`
  top: ${props => props.top};
  right: ${props => props.right};
  width: 150px;
  height: 60px;
  position: absolute;
  background-image: url(${props => props.image});
  background-size: cover;
  z-index: 0;
`;


<<<<<<< HEAD

const FirstPagaComponent = () => {
=======
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
  width: 10px;
  height: 10px;
  border-radius: 50%;
  position: absolute;
  background-color: white;
  box-shadow: 0 0 5px 2px rgba(255, 255, 255, 0.7);
  z-index: 0;
  animation: ${snowAnimation} ${props => props.animationDuration}s linear infinite;
`;


const FirstPagaComponent = () => {

>>>>>>> 3d3e228759e1f99953f9fcd007c35cc4491c0ecd
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
  const components = Array.from({ length: 3 }).map((_, index) => {
    const top = getRandomValue(window.innerHeight - 60); // 높이에서 60px 뺀 값으로 설정
    const right = getRandomValue(window.innerWidth - 150); // 너비에서 150px 뺀 값으로 설정
    return (
      <TestStyledComponent
        key={index}
        image={ImageSrc}
        top={top}
        right={right}
      />
    );
  });
<<<<<<< HEAD
  return (
    <div className="main-container">
      {components}


=======

  const snowflakes = Array.from({ length: 15 }).map((_, index) => {
    const top = getRandomValue(window.innerHeight);
    const left = getRandomValue(window.innerWidth);
    const animationDuration = Math.random() * 5 + 15;
    return (
      <Snow key={index} top={top} left={left} animationDuration={animationDuration} />
    );
  });
  return (
    <div className="main-container">
      {components}
      {snowflakes}
>>>>>>> 3d3e228759e1f99953f9fcd007c35cc4491c0ecd
      <img className='test-img' src="../../Image/피자뽀이.png" alt="피자뽀이" />
      <div className="main-top">
        <p className="main-title">내가 만약 <span>피자</span>라면?</p>
        <img className='main-title-img' src="../../Image/피자뽀이.png" alt="피자뽀이" />
        <button
          className='start-btn'
          onClick={onStartBtn}
        >시작하기</button>
      </div>
      <div className='main-bottom'>
        <img className='main-bottom-img' src="../../Image/피자결과뽀이.png" alt="피자뽀이" />
      </div>
    </div>
  )
}

export default FirstPagaComponent
