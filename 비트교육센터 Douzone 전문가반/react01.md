# React 기본

## React 이론  
>react 툴 : vsCode Webstorm Slickedit Atom

>react :  
Flux 패턴 (옵저버랑 비슷)  
Flux를 크게 Dispatcher, Store, View 세 부분으로 구성

>리액트의 이해  
MVC패턴에서 View에 특화되어있다

>Component와 class 90% 개념은 비슷하다

>DOM : Tag을 CRUD해주는것  
Ajax : 데이터만 요청해서 넣어주는것  
Virtual DOM : DOM과 비교해서 달라진것만 바꾼다.  
  
>React는 View만 담당하는 라이브러리로 봐라.

## React 명령어
>NodeJS : 설치  
vsCode : 설치  
npm install -g create-react-app : 리액트 설치  
create-react-app --version : 리액트 버전 확인  
create-react-app (프로젝트이름) : 리액트 프로젝트 생성  

>create-react-app test02 && cd test02 && npm start : 3가지 명령어를 연속 실행  
  
>set projectname=test03  
create-react-app %projectname% && cd %projectname% && npm start : 이름만 바꾸면 프로젝트 생성됨  

>yarn start : 리액트 프로젝트 실행  
npm start : 리액트 프로젝트 실행

>npm install (라이브러리 이름) --save : 라이브러리 받아오는 명령어

>rcc : Component 자동완성  
 ## React 코드

 ### JSX
 ```JavaScript
 import React, { Component } from 'react';

class App extends Component {
  render() {
    // JavaScript 코드 영역
    console.log('!!!!!!!!!!!!!호랑이 출력!!!!!!!!!!!!!');
    const s = 'JavaScript로 만든 태그';
    const b = true;
    return (  // jsx문법 HTML + JavaScript의 코드 영역
      // 반듯이 <div>태그가 존재해야한다.
      <div>
        <h1>{b ? '독수리' : '코끼리'}</h1><br/>
        <h1>{s}</h1>
      </div>
    );
  }
}

export default App;
 ```

 >>div태그는 메인헤더 역활을 한다.
 
 >>CSS파일 분리하기  
 ```css
 /* App.css */
 .st1 {
  background-Color: rgb(221, 165, 243);
  border: 1px solid black;
}
```
```JavaScript
// import 후 원하는 태그에 className='.st1'사용한다
import React, { Component } from 'react';
import './App.css';
class App extends Component {
  render() {
    return (  // jsx문법 HTML + JavaScript의 코드 영역
      // 반듯이 <div>태그가 존재해야한다.
      // div태그는 메인헤더 역활을 한다.
      <div className='st1'>
      </div>
    }
  }
}
export default App;
```
>>React의 함수 이용 방법
```JavaScript
// 함수만드는 방법
  // 방법 1
  f1 = function () {
    console.log('f1 func call');
  }
  // 방법 2
  f2() {
    console.log('f2 func call');
  }
  // 방법 3
  f3 = () => {
    console.log('f3 func call');
  }
  f4 = () => {
    alert('까꿍');
  }

<button onClick={this.f1}>버튼1</button>
<button onClick={this.f2}>버튼2</button>
<button onClick={this.f3}>버튼3</button>
<button onClick={this.f4}>버튼4</button>
```
>>Component는 단복태그로 호출이 가능하다.
```JavaScript
import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className='st1'>
        호랑이
        <Bpp/>
      </div>
    );
  }
}
export default App;

class Bpp extends Component {  // 단독태그로 호출가능하다
  render() {
    return (
      <div className='st2'>
        고라니
      </div>
    );
  }
}
```
>>Component 끼리 값 전달 방식
```JavaScript
App에서
      <Dpp name='호랑이' age={10} /> 보내면
Dpp에서 받는다.
      <h1>App => name : {this.props.name}</h1>
      <h1>App => age : {this.props.age}</h1>
      <input type='text' value={this.props.age + 10}/>
```