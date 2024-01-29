import React from 'react';
import styles from './FirstPage.scss'; // 파일명 수정

const FisrtPage = () => {
  return (
    <div className={styles['main-container']}> {/* styles 변수 사용 */}
      <p className={styles['main-title']}>내가 만약 피자라면?</p> {/* styles 변수 사용 */}
      <img src='images/' alt='image' /> {/* 이미지 경로 설정 */}
      <button>시작 하기</button>
      <img src='images/' alt='image' /> {/* 이미지 경로 설정 */}
      firstPage
    </div>
  );
};

export default FisrtPage; // 컴포넌트 이름 수정
