import React, { useEffect, useState } from "react";
import "./ResultPage.scss";
import axios from 'axios';
import LoadingPage from '../loading-page/LoadingPage';

const ResultsPage = () => {
  const [formData, setFormData] = useState({});
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setIsLoading(true);
      try {
        const response = await axios.get('http://localhost:8080/result', { withCredentials: true });
        setFormData(response.data);
      } catch (e) {
        console.error(e);
      } finally {
        setIsLoading(false);
      }
    };
    fetchData();

    // 페이지 배경색 설정
    document.body.style.backgroundColor = "#ffe5c8";
    
    return () => {
      // 컴포넌트 언마운트 시 배경색 복원
      document.body.style.backgroundColor = "#FFFFFF";
    };
  }, []);

  if (isLoading) {
    return <LoadingPage />;
  }

  // React component
  return (
    <>
      {!isLoading ? (
        <LoadingPage />
      ) : (
        <div className="PageContainer">
          {formData.MBTI}
          <div className="ContentBox">
            <div className="TitleContainer">
              <img className="DeliveryImage" src="/image/pizzaResultBoy.png" alt="pizza delivery" />
              <span className="Title">
                <span className="TitleText">{formData.result_sub_title}</span>
                <span className="TitleTextGroup">
                  <span className="TitleText" style={{ color: "#FF7A00", fontWeight: "bold" }}>
                    {formData.result_title}
                  </span>
                  <span className="TitleText">같은 당신</span>
                </span>
              </span>
            </div>
            <span className="Content" style={{ color: "#FF7A00", fontWeight: "bold", paddingRight: "5px" }}>
              {formData.result_title}는
            </span>
            <span className="Content">
              {formData.result_description}
            </span>
          </div>
          <div className="ButtonsContainer">
            <div className="Button">다시하기</div>
            <div className="Button">URL 복사하기</div>
            <div className="Button">카카오톡으로 공유</div>
          </div>
        </div>
      )
      }
    </>
  );
};

export default ResultsPage;