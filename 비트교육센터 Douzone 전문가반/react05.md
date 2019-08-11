# React

[React](#react)  
[Redux ( 리덕스 )](#redux--리덕스-)  
[App.js에 Action, Reducer, state 만들기](#appjs에-action-reducer-state-만들기)  
[index.js에 Redux 설정하기](#indexjs에-redux-설정하기)  

## Redux ( 리덕스 )
>npm install 목록
>>npm install redux --save  
npm install react-redux --save  
npm install redux-actions --save

## App.js에 Action, Reducer, state 만들기
```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';

class App extends Component {
  render() {
    return (
      <div>
        <Bpp a='호랑이' b='코끼리' />
        <button onClick={this.props.onMyClick}>TypeError: dispatch is not a function</button>
      </div>
    );
  }
}
// Redux ( 리덕스 )
// 5단계 Action => Component <= state 연결
// 실행 순서 Action Reducer state Component

// Action 1
const Action = (dispatch) => {  // onclick 대신에 onMyClick을 사용한다. : event와 동격
  return {
    onMyClick: () => {
      console.log('Action 1 call~~');
      dispatch({ type: 'MYCLICK', })  // MYCLICK문자열이 작동하면 Reducer의 switch문으로 분기된다.
    },
  }
}
// Action 2
const ActionTo = (dispatch) => {  // onclick 대신에 onMyClick을 사용한다. : event와 동격
  return {
    onMyClick: () => {
      console.log('Action 2 call~~');
      dispatch({ type: 'MYCLICK', })  // MYCLICK문자열이 작동하면 Reducer의 switch문으로 분기된다.
    },
  }
}
// Reducer 1
export function reducer(state = { num: 10, }, Action) {  // state의 상태 변화는 Reducer함수에서만 일어난다 : Reducer는 순수함수
  // index.js에 import해준다.  // Reducer의 인자의 state값을 초기화한다.
  switch (Action.type) {
    // TODO------------------------------------------------
    case 'MYCLICK':
      console.log('Reducer 1 MYCLICK call~~');
      return state;
    // ----------------------------------------------------
    default:
      return state;
  }
}
// state2
const stateTo = (state) => {  // 데이터 갱신은 꼭 Reducer에서한다
  return {
    num: state.num,
  }
}
// 5단계
// import { connect } from 'react-redux'; 추가
// export default connect(state, action)(App); 추가
export default connect(
  stateTo,
  ActionTo
)(App);

const Bpp = ({ a, b }) => {  // 직접 바로 객체로 받을수있다 or props받아서 props.a로 사용할수있다.
  return (
    <div>
      안녕 난 Bpp야<br />
      <h1>{a}</h1>
      <h1>{b}</h1>
    </div>
  );
};
```
## index.js에 Redux 설정하기
```javascript
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

// 4단계 reducer를 store에 등록
import App, { reducer } from './App';  // Reducer를 import해준다.
import { createStore } from 'redux';
import { Provider } from 'react-redux';

import * as serviceWorker from './serviceWorker';

// store를 생성하면서 reducer를 추가한다.
const store = createStore(reducer);

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementById('root')
    );

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
```

```javascript
```

```javascript
```

```javascript
```

```javascript
```

```javascript
```
