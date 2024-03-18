import React from 'react'

const SkeletonBtn = () => {
  return (
    <>
      <button className='question-answer-btn'>
        <div className='SkeletonContainer'>
          <span className='LoadingTextd'>잠</span>
          <span className='LoadingTextd'>시</span>
          <span className='LoadingTextd'>만</span>
          <span className='LoadingTextd'>기</span>
          <span className='LoadingTextd'>다</span>
          <span className='LoadingTextd'>려</span>
          <span className='LoadingTextd'>주</span>
          <span className='LoadingTextd'>세</span>
          <span className='LoadingTextd'>요!</span>
        </div>
      </button>
    </>
  )
}

export default SkeletonBtn
