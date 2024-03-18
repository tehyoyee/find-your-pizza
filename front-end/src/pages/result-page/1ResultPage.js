import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import "./ResultPage.scss";
import axios from "axios";
import LoadingPage from "../loading-page/LoadingPage";

const ResultsPage = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({});
  const [isLoading, setIsLoading] = useState(true);
  const [cookies] = useCookies(["uuid"]);
  const uuid = cookies.uuid;

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_URL}/result`, {
          withCredentials: true,
        });
        setTimeout(() => {
          setFormData(response.data);
          setIsLoading(false);
        }, 2000);
      } catch (e) {
        console.error(e);
        setIsLoading(false);
      }
    };
    fetchData();

    document.body.style.backgroundColor = "#ffe5c8";

    return () => {
      document.body.style.backgroundColor = "#FFFFFF";
    };
  }, [uuid]);

  const copyToClipboard = async () => {
    try {
      const shareUrl = `${window.location.origin}/result?uuid=${uuid}`;
      await navigator.clipboard.writeText(shareUrl);
      alert("URL이 클립보드에 복사되었습니다.");
    } catch (err) {
      console.error("클립보드 복사 실패:", err);
    }
  };

  if (isLoading) {
    return <LoadingPage />;
  }

  // React component
  return (
    <>
      {isLoading ? (
        <LoadingPage />
      ) : (
        <div className="PageContainer">
          {formData.mbti}
          <div className="ContentBox">
            <div className="TitleContainer">
              <img
                className="DeliveryImage"
                src="Image/pizzaResultBoy.png"
                alt="pizza delivery"
              />
              <span className="Title">
                <span className="TitleText">{formData.resultSubTitle}</span>
                {/* <span className="TitleText">으스스한 매콤함</span> */}
                <span className="TitleTextGroup">
                  <span
                    className="TitleText"
                    // style={{ color: "#FF7A00", fontWeight: "bold", fontSize: formData.resultTitle && formData.resultTitle.length > 7 ? "1em" : "1.3em"}}
                  >
                    {formData.resultTitle}
                  </span>
                  {/* <span
                    className="TitleText"
                  >
                    고스트 페퍼로니 피자
                  </span> */}
                  <span className="TitleText">같은 당신</span>
                </span>
              </span>
            </div>
            <span
              className="Content"
              style={{
                color: "#FF7A00",
                fontWeight: "bold",
                paddingRight: "5px",
                // fontSize: formData.resultTitle && formData.resultTitle.length > 7 ? "1em" : "1.3em"
              }}
            >
              {formData.resultTitle}는
            </span>
            <span className="Content">{formData.resultDescription}</span>
          </div>
          <div className="ButtonsContainer">
            <div className="Button" onClick={() => navigate("/")}>
            다시하기
            </div>
            <div className="Button" onClick={copyToClipboard}>
              URL 복사하기
            </div>
            <div className="Button">카카오톡으로 공유</div>
          </div>
        </div>
      )}
    </>
  );
};

export default ResultsPage;
