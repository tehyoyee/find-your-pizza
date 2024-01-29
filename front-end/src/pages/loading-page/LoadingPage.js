import React from "react";
import styled from "styled-components";

const LoadingContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #ffcc93;
  font-size: 3em;
  font-weight: 800;
  line-height: normal;
  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`;

const DeliveryImage = styled.img`
  width: 320px;
  height: auto;
  margin-bottom: 20px;
`;

const LoadingTextContainer = styled.span`
display: flex;
flex-direction: row;
`;

// LoadingText 컴포넌트는 각 글자에 적용될 스타일을 정의합니다.
const LoadingText = styled.span``;

const LoadingPage = () => {
  return (
    <LoadingContainer>
      <DeliveryImage src="/image/피자뽀이.png" alt="피자 배달" />
      <LoadingTextContainer>
        <LoadingText style={{ color: "red" }}>결</LoadingText>
        <LoadingText style={{ color: "orange" }}>과</LoadingText>
        <LoadingText style={{ color: "yellow" }}>배</LoadingText>
        <LoadingText style={{ color: "green" }}>달</LoadingText>
        <LoadingText style={{ color: "blue" }}>중</LoadingText>
        <LoadingText style={{ color: "purple" }}>...</LoadingText>
      </LoadingTextContainer>
    </LoadingContainer>
  );
};

export default LoadingPage;
