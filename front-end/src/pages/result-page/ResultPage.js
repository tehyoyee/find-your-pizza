import React from "react";
import styled from "styled-components";

// Styled components here
const PageContainer = styled.div`
  width: 446px;
  height: 926px;
  background-color: #ffe5c8;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
`;

const TitleContainer = styled.div`
  display: flex;
  margin-top: 10%;
`;

const DeliveryImage = styled.img`
  width: 144px;
  height: 138px;
  z-index: 3;
`;

const Title = styled.span`
  font-size: 1.9em;
  margin-top: 13%;
`;

const TitleTextGroup = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0;
  font-size: 1em;
`;

const TitleText = styled.span`
  font-weight: normal;
`;

const ContentBox = styled.div`
  background: #ffffff;
  width: 80%;
  margin: 20px 0;
  border-radius: 10px;
  padding: 20px;
  position: relative;
  z-index: 2;
`;

const Content = styled.div`
  font-size: 1.3em;
`;

const ButtonsContainer = styled.div`
  /* Style your button here */
`;

const Button = styled.button`
  background: #ffb703;
  border: 1px solid #000;
  border-radius: 30px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  padding: 10px 15px;
  margin-right: 15px;
  margin-top: 30px;
  cursor: pointer;
  color: white;
  font-size: 1em;
  font-weight: 800;
`;

// React component
const ResultsPage = ({ title, content, imageUrl }) => {
  return (
    <PageContainer>
      <TitleContainer>
        <DeliveryImage src="/image/pizzaResultBoy.png" alt="pizza delivery" />
        <Title>
          <TitleText>담백한</TitleText>
          <TitleTextGroup>
            <TitleText style={{ color: "#FF7A00", fontWeight: "bold" }}>
              포테이토 피자
            </TitleText>
            <TitleText>같은 당신</TitleText>
          </TitleTextGroup>
        </Title>
      </TitleContainer>

      <ContentBox>
        <Content style={{ color: "#FF7A00", fontWeight: "bold" }}>
          포테이토 피자,
        </Content>
        <Content>
          기본적인 재료인 감자로 독특하고 담백한 맛을 만들어냅니다. 포테이토
          피자는 내적인 가치와 깊은 사고를 중요시하는 성격 유형으로, 겉으로
          보기에는 단순해 보일 수 있지만, 속은 풍부하고 복잡한 내면의 세계를
          가지고 있습니다. 마치 포테이토 피자가 겉보기에는 소박해 보이지만, 그
          맛이 깊고 풍부한 것처럼 말이죠.
        </Content>
        <p></p>
        <Content>
          포테이토 피자는 통찰력이 뛰어나고, 사람들의 감정과 동기에 대해 깊이
          이해하며, 종종 다른 사람들의 필요를 자신의 것보다 앞세우는 경향이
          있습니다. 이들은 포테이토 피자처럼 겸손하고 진실되며, 자신의 가치와
          신념을 강하게 지킵니다. 포테이토 피자가 제공하는 부드러우면서도 깊은
          맛은 포테이토 피자의 섬세하고 진지한 성격을 잘 반영합니다.
        </Content>
      </ContentBox>
      <ButtonsContainer>
        <Button>다시하기</Button>
        <Button>URL 복사하기</Button>
        <Button>카카오톡으로 공유</Button>
      </ButtonsContainer>
    </PageContainer>
  );
};

export default ResultsPage;
