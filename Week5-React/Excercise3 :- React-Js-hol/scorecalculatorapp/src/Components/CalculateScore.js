import React from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = ({ Name, School, Total, goal }) => {
  const average = (Total / goal).toFixed(2);
  return (
    <div className="score-card">
      <h2 className="score-card-title">Student Scorecard</h2>
      <div className="score-detail">
        <p><span className="detail-label">Name:</span> <span className="detail-value">{Name}</span></p>
        <p><span className="detail-label">School:</span> <span className="detail-value">{School}</span></p>
        <p><span className="detail-label">Total Score:</span> <span className="detail-value">{Total}</span></p>
        <p><span className="detail-label">Target (Goal):</span> <span className="detail-value">{goal}</span></p>
        <p><span className="detail-label">Average Score:</span> <span className="detail-value average">{average}</span></p>
      </div>
    </div>
  );
};

export default CalculateScore;
