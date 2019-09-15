# Hooks
[Hooks](#hooks)  
[useState](#usestate)  
[useEffect](#useeffect)  

## useState
함수형 카운터
```javascript
import React, { useState } from 'react';
import './App.css';

const App = () => {
  const [item, setItem] = useState(1);
  const pl = () => setItem(item + 1)
  const min = () => setItem(item - 1)

  return (
    <div className="App">
      <header className="App-header">
        <h1>Hello {item}</h1>
        <button onClick={pl}>더하기</button>
        <button onClick={min}>빼기</button>
      </header>
    </div>
  );
}
export default App;
```
클래스형 카운터
```javascript
import React, { useState } from 'react';
import './App.css';

class App extends React.Component{
  state = {
    item: 1,
  }
  render() {
    const { item } = this.state;
    return (
      <div className="App">
      <header className="App-header">
        <h1>Hello {item}</h1>
        <button onClick={this.pl}>더하기</button>
        <button onClick={this.min}>빼기</button>
      </header>
    </div>
    )
  }
  pl = () => {
    this.setState(state => {
      return {
        item: state.item + 1
      }
    })
  }
  min = () => {
    this.setState(state => {
      return {
        item: state.item + 1
      }
    })
  }
}
export default App;
```

## useEffect
```javascript
import React, { useState, useEffect } from 'react';
import './App.css';

const App = () => {
  const sayHello = () => { console.log("hello"); }
  // componentDidmount역할과 componentDidUpdate역할을 한다
  useEffect(() => {
    sayHello();
  })

  const [number, setNumber] = useState(0);
  const [aNumber, setAnumber] = useState(0);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Hello</h1>
        <button onClick={()=>{setNumber(number + 1)}}>{number}</button>
        <button onClick={()=>{setAnumber(aNumber + 1)}}>{aNumber}</button>
      </header>
    </div>
  );
}
export default App;
```

>useEffect는 두번째 인자의 값이 변화하면 첫번째 인자의 함수가 실행된다.
```javascript
import React, { useState, useEffect } from 'react';
import './App.css';

const App = () => {
  const sayHello = () => { console.log("hello"); }

  const [number, setNumber] = useState(0);
  const [aNumber, setAnumber] = useState(0);
  // componentDidmount역할과 componentDidUpdate역할을 한다  
  useEffect(sayHello, [number, aNumber]);
  return (
    <div className="App">
      <header className="App-header">
        <h1>Hello</h1>
        <button onClick={()=>{setNumber(number + 1)}}>{number}</button>
        <button onClick={()=>{setAnumber(aNumber + 1)}}>{aNumber}</button>
      </header>
    </div>
  );
}
export default App;
```
```javascript
import React, { useState, useEffect } from 'react';
import './App.css';

const useTitle = (initialTitle) => {
  const [title, setTitle] = useState(initialTitle);
  const updateTitle = () => {
    const htmlTitle = document.querySelector("title");
    htmlTitle.innerText = title;
  }
  useEffect(updateTitle, [title])
  return setTitle;
}

const App = () => {
  const titleUpdater = useTitle("Loading...")
  setTimeout(() => titleUpdater("home"), 5000)
  return (
    <div className="App">
      <header className="App-header">
        <h1>Hello</h1>
      </header>
    </div>
  );
}
export default App;
```