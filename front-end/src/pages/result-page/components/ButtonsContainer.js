import React from "react";


const ButtonsContainer = ({ onRetry, onCopy }) => {
  return (
    <div className="ButtonsContainer">
      <div className="Button" onClick={onRetry}>
        다시하기
      </div>
      <div className="Button" onClick={onCopy}>
        URL 복사하기
      </div>
      {/* 카카오톡 공유 기능을 구현할 경우에는 여기에 추가 */}
      <div className="Button">카카오톡으로 공유</div>
    </div>
  );
};

export default ButtonsContainer;
