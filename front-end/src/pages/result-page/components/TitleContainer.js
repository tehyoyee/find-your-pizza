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
          <span className="TitleText">{formData.resultTitle}</span>
          <span className="TitleText">같은 당신</span>
        </span>
      </span>
    </div>
  );
};

export default TitleContainer;