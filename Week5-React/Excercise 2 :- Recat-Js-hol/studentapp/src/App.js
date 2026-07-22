import React, { Component } from 'react';
import Home from './Components/Home';
import About from './About';
import Contact from './Contact';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Home />
        <About />
        <Contact />
      </div>
    );
  }
}

export default App;
