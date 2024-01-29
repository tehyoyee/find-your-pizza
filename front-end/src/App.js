import './App.scss'
import { Route, Routes } from 'react-router-dom';
import FisrtPage from './pages/first-page/FisrtPage';
import QuestionPage from './pages/question-page/QuestionPage';
import ResultPage from './pages/result-page/ResultPage';

function App() {
  return (
    <div className='body'>
      라우터 이외 공간
      <Routes>
        <Route path='/' element={<FisrtPage />} /> {/* 첫 시작 페이지 */}
        <Route path='/question' element={<QuestionPage />} />
        {/* <Route path='/loading' element={<LoadingPage />} /> 이 부분을 결과랑 같이 둬야함 */}
        <Route path='/result' element={<ResultPage />} />
      </Routes>
    </div>
  );
}

export default App;
