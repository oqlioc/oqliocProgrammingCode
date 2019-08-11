# React

  
[React](#react)  
[기본 배열의 concat, slice 활용](#기본-배열의-concat-slice-활용)  
[ES6 전개연산자](#es6-전개연산자)  
[ES6 전개연산자를 활용한 예제](#es6-전개연산자를-활용한-예제)  
[비구조 할당](#비구조-할당)  
[ES6 전개연산자 + 비구조할당을 활용한 예제](#es6-전개연산자--비구조할당을-활용한-예제)  
[함수형 Component의 사용법](#함수형-component의-사용법)  

## 기본 배열의 concat, slice 활용
```javascript
let ar = [10, 20, 30, 40, 50];
console.log('ar : ', ar);
console.log('---------------------------------');
let br = ar.concat(60)  // 원본데이터를 살려놓고 배열을 return한다
console.log('br : ', br);
console.log('ar : ', ar);
console.log('---------------------------------');
let cr = ar.slice(0, 3)  // 2번부터 4 - 1 까지 짜른다
console.log('cr : ', cr);
console.log('ar : ', ar);
console.log('---------------------------------');
console.log(ar.pop());
console.log('ar : ', ar);
```

## ES6 전개연산자
```javascript
// 전개연산자
let ar = [10, 20, 30, 40];
let br = [50, ...ar, 60]  // ...ar 배열 사이에 배열끼워넣기
console.log(br);
const obj1 = { 
    a: 10, 
    b: 20, 
    c:30,
}
const obj2 = {  // ...ar 배열 사이에 배열끼워넣기
    d: 40, 
    ...obj1,
    e: 50,
}
console.log(obj2);
console.log('---------------------------------');
function f1() {  // 객체 return
    return {
        a: 10,
        b:20,
    }
}
console.log(f1());
const obj3 = {  // return된 객체를 전개연산자
    c: 30,
    d: 40,
    ...f1(),
}
console.log(obj3);
```

## ES6 전개연산자를 활용한 예제
```javascript
import React, { Component } from 'react';

class App extends Component {
  state = {
    ar: ['호랑이', '독수리', '코끼리'],
  }
  render() {
    let br = this.state.ar.map((v, k) =>
      <li onDoubleClick={() => {
        console.log(k);
        this.setState({
          ar: [
                ...this.state.ar.slice(0, k), 
                ...this.state.ar.slice(k + 1, this.state.ar.length)
              ],
          // ar: this.state.ar.slice(0, k).concat(this.state.ar.slice(k + 1, this.state.ar.length))
          // 전개연산자로 .concat를 날려버린다.
        })
      }}
      key={k}>{v}</li>
    );
    return (
      <div>

        <button onClick={() => {
          this.setState({
            ar: this.state.ar.concat('다람쥐'),
          })
        }}>추가 버튼</button>

        <button onClick={() => {
          this.setState({
            ar: this.state.ar.slice(0, this.state.ar.length - 1),
          })
        }}>제거 버튼</button>

        <ul>
          {br}
        </ul>

      </div>
    );
  }
}

export default App;
```
## 비구조 할당
```javascript
// 비구조화 할당
const cr = [10, 20, 30]

const {x, y, z} = cr

const obj4 = {
    a: 10,
    b: 20,
}
const { a, c } = obj4
```
## ES6 전개연산자 + 비구조할당을 활용한 예제
```javascript
class App extends Component {
  state = {
    ar: ['호랑이', '독수리', '코끼리'],
  }
  render() {
    // const ar = this.state.ar;  // 비구조할당
    const { ar } = this.state;  // state안의 { ar }과 똑같은 이름 들고온다

    let br = ar.map((v, k) =>
      <li onDoubleClick={() => {
        console.log(k);
        this.setState({
          ar: [
                ...ar.slice(0, k), 
                ...ar.slice(k + 1, ar.length)
              ],
              .
              .
              .
              이하생략
```

## 함수형 Component의 사용법
```javascript
// 함수형 Component (단축키 rsc)
// 내가 만든 Component에 state를 사용안할거면 함수형 Component을 사용한다.
// 라이프사이클이 없다.
import React, { Component } from 'react';
class App extends Component {
  render() {
    return (
      <div>
        <Bpp a='호랑이' b='코끼리'/>
      </div>
    );
  }
}
export default App;
const Bpp = ({a, b}) => {  // 직접 바로 객체로 받을수있다 or props받아서 props.a로 사용할수있다
  return (
    <div>
      안녕 난 Bpp야<br/>
      <h1>{a}</h1>
      <h1>{b}</h1>
    </div>
  );
};
```