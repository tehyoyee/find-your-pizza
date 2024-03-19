import React from "react";
import "./TitleContainer.scss";

const TitleContainer = ({ formData }) => {
  return (
    <div className="TitleContainer">
      <img
        className="DeliveryImage"
        src="Image/pizzaResultBoy.png"
        alt="pizza delivery"
      />
      <span className="Title">
        <span className="TitleText">{formData.resultSubTitle}</span>
        <span className="TitleTextGroup">
          <span className="TitleText" style={{ color: "#FF7A00", fontSize: "23px" }}>
            {formData.resultTitle}
          </span>
          <span className="TitleText">같은 당신</span>
        </span>
      </span>
      {/* <span className="Title">
        <span className="TitleText">으스스한 매콤함</span>
        <span className="TitleTextGroup">
          <span className="TitleText" style={{ color: "#FF7A00", fontSize: "23px" }}>
            고스트 페퍼피자
          </span>
          <span className="TitleText">같은 당신</span>
        </span>
      </span> */}
    </div>
  );
};

export default TitleContainer;
