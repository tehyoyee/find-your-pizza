import React, { useEffect } from 'react';
import PizzaFlakes from './components/PizzaFlakes';
import styles from './FirstPage.module.scss';
import StartBtn from './components/StartBtn';

import { useCookies } from 'react-cookie';

const FirstPage = () => {
  const [cookies, setCookies, removeCookie] = useCookies(['uuid'])

  useEffect(() => {
    removeCookie('uuid');
  }, [])

  return (
    <div id='root' className={styles.root} >

      <div className={styles.FirstPageContainer}>

        <div className={styles.FirstPageTop}>
          <div style={{ width: '100%', height: '100px' }} />
          <div className='Images'>
            <img className={styles.MainPizzaBoy} src='Image/pizzaBoy.png' alt='PizzaBoy' />
            <img className={styles.MainPizzaIcon1} src='Image/pizzaIcon.png' alt='PizzaIcon' />
            <img className={styles.MainPizzaIcon2} src='Image/pizzaIcon.png' alt='PizzaIcon' />
          </div>
          <p>내가 만약 <span>피자</span>라면?</p>
          <img className={styles.FirstPageMainImg} src='Image/pizzaBoy.png' alt='PizzaBoy' />
          <StartBtn />
        </div>
        <div className={styles.FirstPageBottom}>
          <img src='Image/djSimpson.png' alt='simpsonPizza' />
        </div>
      </div>
      <PizzaFlakes />
    </div>
  );
};

export default FirstPage;