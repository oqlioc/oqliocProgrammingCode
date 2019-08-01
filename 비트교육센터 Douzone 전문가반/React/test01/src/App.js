import React, { Component } from 'react';
import './App.css';
import Bpp from './Ap/bpp';

class App extends Component {
  render() {
    return (
      <div className='st2'>
        App
        <Bpp />
        <Dpp name='호랑이' age={10} />
      </div>
    );
  }
}
export default App;  // 하나의 파일에서 하나만 존재

class Dpp extends Component {
  render() {
    
    return (
      <div>
        Dpp
        <h1>App => name : {this.props.name}</h1>
        <h1>App => age : {this.props.age}</h1>
        <input type='text' value={this.props.age + 10}/>
      </div>
    )
  }
}