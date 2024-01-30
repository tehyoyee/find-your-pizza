import React from 'react'
import '../../pages/first-page/FirstPage.scss'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import styled from 'styled-components'

const ImageSrc = '../../Image/피자뽀이.png';

const getRandomValue = (max) => `${Math.floor(Math.random() * max)}px`;

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
  return (
    <div className="main-container">
      {components}


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
