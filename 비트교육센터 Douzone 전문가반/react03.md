# React
  
[React](#react)  
[ES6 동적 객체 키 [Dynamic Object Keys]](#es6-동적-객체-키-dynamic-object-keys)  
[map 사용법](#map-사용법)  
[map으로 'li'태그 반복하기](#map으로-li태그-반복하기)  
[라이프사이클(Lifecycle)](#라이프사이클lifecycle)  

## ES6 동적 객체 키 [Dynamic Object Keys]
```javascript
let n = 'a'

let obj = {
    [n]: 0,  // []이걸 a라고해줌
    b: 10,
    c: 20,
}

console.log(obj);
```

```javascript
import React, { Component } from 'react';
class EventPractice extends Component {
  state = {
    username: '',
    message: ''
  }
  handleChange = (e) => {  // 창 하나를 선택해서 두개 중에 state(username, message)을 value로 바꾼다
    this.setState({
      [e.target.name]: e.target.value  // 어떤 창의 e.target.name을 식별하여 state(username, message)의 값을 e.target.value으로 바꾼다
    });
  }
  handleClick = () => {  // 확인 버튼을 누르면 alert창을 실행시키고 초기화
    alert(this.state.username + ': ' + this.state.message);
    this.setState({
      username: '',
      message: ''
    });
  }
  handleKeyPress = (e) => {  // 메시지창을 입력하다가 Enter를 치면 실행
    if (e.key === 'Enter') {
      this.handleClick();
    }
  }
  render() {    
    return (
      <div>
        <h1>이벤트 연습</h1>
        <input 
          type="text"
          name="username"  // 클라이언트에서 값을받을때 사용하는 식별자
          placeholder="유저명"
          value={this.state.username}
          onChange={this.handleChange}
        />
        <input 
          type="text"
          name="message"
          placeholder="아무거나 입력해보세요"
          value={this.state.message}
          onChange={this.handleChange}
          onKeyPress={this.handleKeyPress}
        />
        <button onClick={this.handleClick} >확인</button>
      </div>
    );
  }
}
export default EventPractice;
```

## map 사용법
```javascript
let ar = [10, 20, 30, 40]
let br = ar.map((n) => {
    console.log(n);
    return n * 10
});

console.log('ar : ',ar);
console.log('br : ',br);

let cr = ar.map((n, k) => {
    console.log(n, k);
    return n
});

console.log('cr : ',cr);
```
```javascript
let dr = [
    {
        a: 10, 
        b: 20, 
    },
    {
        c: 30, 
        d: 40, 
    }
]

let er = dr.map((v, k) => {
        console.log(v, k);
        return v
    })

console.log('er : ', er);
```

## map으로 'li'태그 반복하기
```javascript
import React, { Component } from 'react';
class App extends Component {
  render() {
    let ar = ['호랑이', '독수리', '코끼리'];
    let br = ar.map((v, k) => {  // map로 배열만큼 돌아가면서 key값과 value값을 넣어준다
      return <li key={k}>{v}</li>
    });
    return (
      <div>
        <ul>
          {br}
        </ul>
      </div>
    );
  }
}
export default App;
```

## 라이프사이클(Lifecycle)
```javascript
// 1번 8번 2번 이 출력된다.
import React, { Component } from 'react';
class App extends Component {
  // Will 어떤 작업을 하기 전에
  // Did 어떤 작업을 하고 나서
  // Mount ( 장비를 마운트한다. 라는 뜻이다) 반대 Unmount
  componentWillMount() {
    console.log(1);
  }
  componentDidMount() {
    console.log(2);
  }
  componentWillReceiveProps(nextProps) {
    console.log(3);
  }
  shouldComponentUpdate(nextProps, nextState) {
    console.log(4);
  }
  componentWillUpdate(nextProps, nextState) {
    console.log(5);
  }
  componentDidUpdate(prevProps, prevState) {
    console.log(6);
  }
  componentWillUnmount() {
    console.log(7);
  }
  render() {
    console.log(8);
    return (
      <div>
        <Bpp name='App에서 Bpp로 왔어요' />
      </div>
    );
  }
}
App.propTypes = {
};
export default App;
class Bpp extends Component {
  render() {
    return (
      <div>
        나는 Bpp다 <br />
        {this.props.name}
      </div>
    );
  }
}
```