import React from 'react';
import CohortDetails from './CohortDetails';
import './App.css';

function App() {
  const cohorts = [
    {
      id: 1,
      name: "FSE Java Full Stack",
      startDate: "2026-06-01",
      endDate: "2026-09-01",
      status: "ongoing",
      students: 25
    },
    {
      id: 2,
      name: "AWS Cloud Architect",
      startDate: "2026-04-15",
      endDate: "2026-07-15",
      status: "completed",
      students: 40
    },
    {
      id: 3,
      name: "React Developer Program",
      startDate: "2026-07-10",
      endDate: "2026-10-10",
      status: "ongoing",
      students: 30
    }
  ];

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1 style={{ borderBottom: '2px solid #333', paddingBottom: '10px', textAlign: 'center' }}>
        Academy Dashboard
      </h1>
      <div style={{ textAlign: 'center', marginTop: '30px' }}>
        {cohorts.map(cohort => (
          <CohortDetails key={cohort.id} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
