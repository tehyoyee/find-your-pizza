import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import "./ResultPage.scss";
import axios from "axios";
import LoadingPage from "../loading-page/LoadingPage";
import TitleContainer from "../result-page/components/TitleContainer";
import ContentBox from "../result-page/components/ContentBox";
import ButtonsContainer from "../result-page/components/ButtonsContainer";

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
    }, [cookies.uuid]);

    const handleRetry = () => {
      navigate("/");
    };
    
    const handleCopy = async () => {
      try {
        const shareUrl = `${window.location.origin}/result?uuid=${uuid}`; // uuid 사용
        await navigator.clipboard.writeText(shareUrl);
        alert("URL이 클립보드에 복사되었습니다.");
      } catch (err) {
        console.error("클립보드 복사 실패:", err);
      }
    };
    
  
    if (isLoading) {
      return <LoadingPage />;
    }

    
    return (
      <div className="PageContainer">
        <TitleContainer formData={formData} />
        <ContentBox formData={formData} />
        <ButtonsContainer onRetry={handleRetry} onCopy={handleCopy} />
      </div>
    );
  };
  
  export default ResultsPage;