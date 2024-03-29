import React from "react";
const ButtonsContainer = ({ onRetry, onCopy }) => {
    const shareKakao = () => {
        if (window.Kakao && window.Kakao.isInitialized()) {
          window.Kakao.Link.sendCustom({
            templateId: 106291,
          });
        } else {
          console.log('Kakao SDK not initialized.');
        }
      };

  return (
    <div className="ButtonsContainer">
      <div className="Button" onClick={onRetry}>
        다시하기
      </div>
      <div className="Button" onClick={onCopy}>
        결과 공유하기
      </div>
      <div className="Button" onClick={shareKakao}>
        친구들은 어떤 피자일까?
      </div>
    </div>
  );
};

export default ButtonsContainer;
