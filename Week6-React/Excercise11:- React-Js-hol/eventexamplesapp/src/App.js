import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

function App() {
  const [counter, setCounter] = useState(0);
  const [helloText, setHelloText] = useState('');
  const [welcomeText, setWelcomeText] = useState('');
  const [syntheticText, setSyntheticText] = useState('');

  // 1. Increment button triggering multiple operations
  const handleIncrement = () => {
    // a. To increment the value
    setCounter(prev => prev + 1);
    // b. Say Hello followed by a static message
    setHelloText('Hello! You successfully incremented the counter.');
  };

  // Decrement button
  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  // 2. Say Welcome which takes welcome as an argument
  const handleSayWelcome = (message) => {
    setWelcomeText(`Welcome message received: "${message}"`);
  };

  // 3. Button which invokes synthetic event (onClick) to display "I was clicked"
  const handleSyntheticClick = (e) => {
    // Accessing synthetic event details to demonstrate its usage
    console.log("Synthetic Event Type:", e.type);
    setSyntheticText("I was clicked");
  };

  return (
    <div className="App" style={{ fontFamily: 'Arial, sans-serif', padding: '30px', backgroundColor: '#f0f2f5', minHeight: '100vh' }}>
      <h1 style={{ textAlign: 'center', color: '#333' }}>React Events &amp; Forms Showcase</h1>

      <div style={{ maxWidth: '800px', margin: '0 auto' }}>
        {/* Counter Section */}
        <div style={{ padding: '20px', background: '#fff', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', marginBottom: '20px' }}>
          <h2>1. Counter (Event Handling &amp; Multiple Methods)</h2>
          <p style={{ fontSize: '20px', fontWeight: 'bold' }}>Counter Value: <span id="counter-value">{counter}</span></p>

          <button 
            onClick={handleIncrement}
            style={{ padding: '10px 20px', background: '#28a745', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer', marginRight: '10px' }}
            id="increment-btn"
          >
            Increment
          </button>

          <button 
            onClick={handleDecrement}
            style={{ padding: '10px 20px', background: '#dc3545', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
            id="decrement-btn"
          >
            Decrement
          </button>

          {helloText && (
            <p style={{ marginTop: '15px', color: '#555', fontStyle: 'italic', borderLeft: '3px solid #28a745', paddingLeft: '10px' }} id="hello-message">
              {helloText}
            </p>
          )}
        </div>

        {/* Say Welcome Section */}
        <div style={{ padding: '20px', background: '#fff', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', marginBottom: '20px' }}>
          <h2>2. Parameterized Event Handler</h2>
          <button 
            onClick={() => handleSayWelcome("welcome")}
            style={{ padding: '10px 20px', background: '#17a2b8', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
            id="welcome-btn"
          >
            Say Welcome
          </button>
          {welcomeText && (
            <p style={{ marginTop: '15px', color: '#17a2b8', fontWeight: 'bold' }} id="welcome-message">
              {welcomeText}
            </p>
          )}
        </div>

        {/* Synthetic Event Section */}
        <div style={{ padding: '20px', background: '#fff', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', marginBottom: '20px' }}>
          <h2>3. Synthetic Event (onClick)</h2>
          <button 
            onClick={handleSyntheticClick}
            style={{ padding: '10px 20px', background: '#ffc107', color: '#212529', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
            id="synthetic-btn"
          >
            Trigger Click Event
          </button>
          {syntheticText && (
            <p style={{ marginTop: '15px', color: '#856404', fontWeight: 'bold' }} id="synthetic-message">
              {syntheticText}
            </p>
          )}
        </div>

        {/* Currency Converter */}
        <CurrencyConvertor />
      </div>
    </div>
  );
}

export default App;
