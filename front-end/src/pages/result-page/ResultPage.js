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
  const [cookies, setCookie] = useCookies(["uuid"]);
  const uuid = cookies.uuid;

  useEffect(() => {
    const queryParams = new URLSearchParams(window.location.search);
    const urlUuid = queryParams.get("uuid");
    const cookieUuid = cookies.uuid;

    // fetchData 함수 정의
    const fetchData = async (uuid) => {
      try {
        const response = await axios.get(
          `${process.env.REACT_APP_API_URL}/result/${uuid}`,
          {
            withCredentials: true,
          }
        );
        setTimeout(() => {
          setFormData(response.data);
          setIsLoading(false);
        }, 2000);
      } catch (e) {
        console.error(e);
        setIsLoading(false);
      }
    };

    if (urlUuid) {
      // URL에서 UUID 사용
      setCookie("uuid", urlUuid, {
        domain: `${process.env.REACT_APP_DOMAIN_URL}`,
        path: "/",
        httpOnly: false,
        secure: true,
        maxAge: 36000,
        sameSite: "none",
      });
      fetchData(urlUuid);
    } else if (cookieUuid) {
      // 쿠키에서 UUID 사용
      fetchData(cookieUuid);
    } else {
      // UUID가 없는 경우 메인 화면으로 리다이렉트
      navigate("/");
    }

    // Kakao SDK 초기화 확인 및 설정
    const jsKey = process.env.REACT_APP_KAKAO_KEY;
    if (!window.Kakao.isInitialized()) {
      window.Kakao.init(jsKey);
    }
  }, [navigate, cookies, setCookie]);

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
