import React from "react";

const ButtonsContainer = ({ onRetry, onCopy }) => {
  const shareKakao = () => {
    window.Kakao.Link.sendCustom({
      templateId: 105921,
    });
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
      <div className="kakao-link-btn" onClick={shareKakao}>
        <img
          src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
          alt="카카오링크 보내기 버튼"
        />
      </div>
    </div>
  );
};

export default ButtonsContainer;
