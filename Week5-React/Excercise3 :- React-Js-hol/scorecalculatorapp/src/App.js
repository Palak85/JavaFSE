import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './App.css';

function App() {
  return (
    <div className="App">
      <CalculateScore 
        Name="Palak Singh" 
        School="Cognizant Learning Academy" 
        Total={285} 
        goal={3} 
      />
    </div>
  );
}

export default App;
