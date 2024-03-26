import {REACT_APP_JAVASCRIPT_KEY} from '../';

const {Kakao} = window;

export default function initialize() {
  Kakao.init(REACT_APP_JAVASCRIPT_KEY);
}