import React from "react";

const ButtonsContainer = ({ onRetry, onCopy }) => {
  const shareKakao = () => {
    if (window.Kakao && window.Kakao.isInitialized()) {
      window.Kakao.Link.sendDefault({
        objectType: "feed",
        content: {
          title: "내가 만약 피자라면?",
          description:
            "간단한 심리테스트를 통해 나와 비슷한 피자를 확인해보세요!",
          link: {
            mobileWebUrl: "https://www.find-your-pizza.site",
            webUrl: "https://www.find-your-pizza.site",
          },
        },
        buttons: [
          {
            title: "지금 확인하기",
            link: {
              mobileWebUrl: "https://www.find-your-pizza.site",
              webUrl: "https://www.find-your-pizza.site",
            },
          },
        ],
      });
    } else {
      console.log("Kakao SDK not initialized.");
    }
  };

  return (
    <div className="ButtonsContainer">
      <div className="Button" onClick={onRetry}>
        다시하기
      </div>
      <div className="Button" onClick={onCopy}>
        URL 복사하기
      </div>
      {/* 카카오톡 공유 기능을 구현할 경우에는 여기에 추가 */}
      <div className="Button" onClick={shareKakao}>
        카카오톡으로 공유
      </div>
    </div>
  );
};

export default ButtonsContainer;
