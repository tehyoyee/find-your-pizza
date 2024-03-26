import "./App.scss";
import React, { useEffect } from "react";
import { Route, Routes } from "react-router-dom";
import FisrtPage from "./pages/first-page/FisrtPage";
import QuestionPage from "./pages/question-page/QuestionPage";
import ResultPage from "./pages/result-page/ResultPage";

function App() {
  return (
    <div className="project-main-container">
      <Routes>
        <Route path="/" element={<FisrtPage />} />
        <Route path="/question" element={<QuestionPage />} />
        <Route path="/result" element={<ResultPage />} />
      </Routes>
    </div>
  );
}

export default App;
