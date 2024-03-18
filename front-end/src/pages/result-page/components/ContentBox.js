import React from "react";

const ContentBox = ({ formData }) => {
  return (
    <div className="ContentBox">
      <span className="Content" style={{ color: "#FF7A00", fontWeight: "bold", paddingRight: "5px" }}>
        {formData.resultTitle}는
      </span>
      <span className="Content">{formData.resultDescription}</span>
    </div>
  );
};

export default ContentBox;
