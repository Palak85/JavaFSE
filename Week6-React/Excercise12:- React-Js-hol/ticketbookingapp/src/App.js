import React, { useState } from 'react';
import GuestView from './GuestView';
import UserView from './UserView';
import WarningBanner from './WarningBanner';
import './App.css';

// LoginButton Component
function LoginButton({ onClick }) {
  return (
    <button 
      onClick={onClick} 
      style={{ padding: '8px 16px', fontSize: '14px', background: '#007bff', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer', fontWeight: 'bold' }}
      id="login-btn"
    >
      Log In
    </button>
  );
}

// LogoutButton Component
function LogoutButton({ onClick }) {
  return (
    <button 
      onClick={onClick} 
      style={{ padding: '8px 16px', fontSize: '14px', background: '#dc3545', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer', fontWeight: 'bold' }}
      id="logout-btn"
    >
      Log Out
    </button>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // Element Variable to conditionally store button components
  let authButton;
  if (isLoggedIn) {
    authButton = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    authButton = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div className="App" style={{ fontFamily: 'Arial, sans-serif', padding: '30px', backgroundColor: '#f4f6f9', minHeight: '100vh' }}>
      <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '2px solid #ddd', paddingBottom: '15px', maxWidth: '900px', margin: '0 auto' }}>
        <h1 style={{ margin: 0, color: '#333', fontSize: '24px' }}>Airlines Ticket Booking Portal</h1>
        <div>{authButton}</div>
      </header>

      <main style={{ maxWidth: '900px', margin: '20px auto' }}>
        {/* Demonstrating how to prevent rendering: banner displays only in guest mode */}
        <WarningBanner showWarning={!isLoggedIn} />

        {/* Conditional Rendering between Guest browsing and User booking */}
        {isLoggedIn ? <UserView /> : <GuestView />}
      </main>
    </div>
  );
}

export default App;
