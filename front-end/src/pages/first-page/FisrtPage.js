import React, { useEffect } from 'react';
import PizzaFlakes from './components/PizzaFlakes';
import StartBtn from './components/StartBtn';
import './FirstPage.scss'
import { useCookies } from 'react-cookie';

const FirstPage = () => {
  const [cookies, setCookies, removeCookie] = useCookies(['uuid'])

  useEffect(() => {
    removeCookie('uuid');
  }, [])

  return (
    <div className='FirstPageContainer'>
      <div className='FirstPageTop'>
        <div style={{ width: '100%', height: '100px' }} />
        <div className='Images'>
          <img className='MainPizzaBoy' src='Image/pizzaBoy.png' alt='PizzaBoy' />
          <img className='MainPizzaIcon1' src='Image/pizzaIcon.png' alt='PizzaIcon' />
          <img className='MainPizzaIcon2' src='Image/pizzaIcon.png' alt='PizzaIcon' />
        </div>
        <p>내가 만약 <span>피자</span>라면?</p>
        <img className='FirstPageMainImg' src='Image/pizzaBoy.png' alt='PizzaBoy' />
        <StartBtn />
      </div>
      <div className='FirstPageBottom'>
        <img src='Image/djSimpson.png' alt='simpsonPizza' />
      </div>
      {/* <PizzaFlakes /> */}
    </div>
  );
};

export default FirstPage;