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
  const [cookies, setCookie, removeCookie] = useCookies(["uuid"]);
  const uuid = cookies.uuid;

  const queryParams = new URLSearchParams(window.location.search);
  const urlUuid = queryParams.get("uuid");
  // const cookieUuid = cookies.uuid;

  useEffect(() => {
    if (cookies.uuid) {
      removeCookie("uuid", {
        path: "/",
        // domain 옵션은 필요에 따라 추가
      });
      setCookie("uuid", urlUuid, {
        path: "/",
        domain: process.env.REACT_APP_COOKIE_DOMAIN, // 예: .find-your-pizza.site
        secure: true,
        maxAge: 36000,
        sameSite: "none",
      });
      // fetchData 함수 호출 로직이 이곳으로 이동
    } else if (!urlUuid && !cookies.uuid) {
      // 쿠키와 URL 모두에 UUID가 없는 경우, 메인 화면으로 리다이렉트
      navigate("/");
      return;
    }

    const jsKey = process.env.REACT_APP_KAKAO_KEY;

    if (!window.Kakao.isInitialized()) {
      window.Kakao.init(jsKey);
      console.log(window.Kakao.isInitialized());
    } // 이부분은 index.html에서 sdk가져오는거 그다음에 키값 init해주는 코드에요

    const fetchData = async () => {
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_URL}/result`, {
          withCredentials: true,
        });
        setFormData(response.data);
        setIsLoading(false);
      } catch (e) {
        console.error(e);
        alert("데이터를 가져오는데 실패했습니다. 홈 페이지로 이동합니다.");
        navigate("/");
      }
    };
    fetchData();
    document.body.style.backgroundColor = "#ffe5c8";

  }, []);

  const handleRetry = () => {
    navigate("/");
  };

  const handleCopy = async () => {
    try {
      const shareUrl = `${window.location.origin}/result?uuid=${uuid}`; // uuid 사용
      await navigator.clipboard.writeText(shareUrl);
      alert(
        "결과가 성공적으로 복사되었습니다! 원하시는 곳에 붙여넣기해주세요!"
      );
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
