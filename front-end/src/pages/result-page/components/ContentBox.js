import React from "react";

const ContentBox = ({ formData }) => {
  return (
    <div className="ContentBox">
      <span className="Content" style={{ color: "#FF7A00", fontWeight: "bold", paddingRight: "5px" }}>
        {formData.resultTitle}는
      </span>
      <span className="Content">{formData.resultDescription}</span>
      {/* <span className="Content">콤비네이션 피자는콤비네이션 피자는 다양한 재료가 조화롭게 어우러져 각각의 맛을 돋보이게 하는 대표적인 피자로, 다양한 상황에 필요한 여러 기능을 조화롭고 실질적으로 행동으로 옮길 수 있는 능력을 가지고 있습니다. 콤비네이션 피자의 각각의 토핑처럼, 각각의 역할과 규칙을 중요시하며, 그들이 속한 시스템이나 커뮤니티에서 중추적인 역할을 담당합니다.\n 콤비네이션 피자에서 어떠한 토핑도 지배적으로 다른 토핑을 압도하지 않으며, 모든 토핑이 균형을 이루어 맛의 조화를 이끌어내는 것과 같이, 균형 잡힌 접근 방식으로 문제에 접근하며, 논리와 사실에 기반하여 결정을 내리려 합니다. 신뢰할 수 있고 예측 가능한 방식으로 상황을 관리하는 콤비네이션 피자는 신뢰할 수 있는 맛과 일관성 있고 안정적인 특성을 지니고 있습니다.</span> */}
    </div>
  );
};

export default ContentBox;
