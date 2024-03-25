import React from "react";

const ButtonsContainer = ({ onRetry, onCopy }) => {
  const shareKakao = () => {
    window.Kakao.Link.sendCustom({
      templateId: 105921, // 내가 만든 템플릿 아이디를 넣어주면 된다
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
      <div className="Button" onClick={shareKakao}>
        <img
          src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
          alt="카카오링크 보내기 버튼"
        />
        카카오톡으로 공유
      </div>
    </div>
  );
};

export default ButtonsContainer;
