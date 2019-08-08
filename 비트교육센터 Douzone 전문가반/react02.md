# React

[React](#react)  
[props](#props)  
[state](#state)  
[Error](#error)  
[결론적인 형태](#결론적인-형태)

## props
- this.props  
this.props.num2 = 50;  받는곳에서는 this.props는 값을 갱신할수 없다.
- state 없이는 값을 변경할수없다


## state
- state : 뷰의 값 갱신용은 state  
- 필드 변수 : 내부적으로 작동하는것은 필드 변수
- setState함수는 비동기함수다 (render 전까지는 무조건 실행완료)
```javascript
class Bpp extends Component {
  // 뷰의 값 갱신용은 state
  // 내부적으로 작동하는것은 필드 변수
  //state를 수정할려면 setState를 이용함
  state = {  // 초기화
    n1: 0,
  }
  n2 = 0;
  f1 = () => {
    this.setState({  // setState는 render 함수를 콜하고 실행된다.
      n1: this.state.n1 + 1,
    })
  }
  f2 = () => {  // render 함수가 호출를 안하기에 화면에 로드안됨
    this.n2++;
  }
  render() {
    console.log('-------render 호출--------');
    return (
      <div>
        <h1>props : num1 => {this.props.num1}</h1>
        <h1>props : num2 => {this.props.num2}</h1>
        <h1>props : num3 => {this.props.num3}</h1><br />

        <h1>state : num1 => {this.state.n1}</h1>
        <h1>state : num2 => {this.n2}</h1>
        <button onClick={this.f1} >f1 버튼</button>
        <button onClick={this.f2} >f2 버튼</button>
      </div>
    );
  }
}
```

## Error
```javascript
Failed to compile.

./src/App.js
Attempted import error: 'Cpp' is not exported from './bpp'.
```

## 결론적인 형태
>App.js (npm start 할때의 제일 처음 파일)  
ㄴ 폴더1 컴포넌트 자체를 임포트  
>>ㄴ bpp.js 컴포넌트 임포트  
ㄴ cpp.js 컴포턴트 임포트

>ㄴ 폴더2 컴포넌트 자체를 임포트  
>>ㄴ dpp.js 컴포넌트 임포트  
ㄴ epp.js 컴포턴트 임포트 

>ㄴ 폴더3 컴포넌트 자체를 임포트  
>>ㄴ fpp.js 컴포넌트 임포트  
ㄴ gpp.js 컴포턴트 임포트 
```javascript
import React, { Component } from 'react';
// 미리 만든 index.js의 Component 통채로 사용한다.
// 그리고 폴더 통채로 관리하여 유지 보수를 쉽게 만든다.
import Sub1 from './sub1/index';
import Sub2 from './sbu2/index';
import Sub3 from './sub3/index';

function f1() {
  console.log('f1 func call @@@@@@@@@@@@@');
}

class App extends Component {
  render() {
    f1();
    return (
      <div>
        <Sub1/>
        <Sub2/>
        <Sub3/>
      </div>
    );
  }
}

export default App;
```