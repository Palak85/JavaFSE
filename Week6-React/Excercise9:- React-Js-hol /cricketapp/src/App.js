import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1 style={{ textAlign: 'center' }}>Cricket Academy Portal</h1>
      <div style={{ textAlign: 'center', marginBottom: '20px' }}>
        <button 
          onClick={() => setFlag(!flag)} 
          style={{
            padding: '10px 20px',
            fontSize: '15px',
            cursor: 'pointer',
            border: '2px solid #8b7355',
            borderRadius: '4px',
            background: '#fffdf6',
            color: '#1b2a41',
            fontFamily: 'monospace'
          }}
          id="toggle-btn"
        >
          Toggle Flag (Current Flag: {String(flag)})
        </button>
      </div>

      <div className="content-container">
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </div>
    </div>
  );
}

export default App;
