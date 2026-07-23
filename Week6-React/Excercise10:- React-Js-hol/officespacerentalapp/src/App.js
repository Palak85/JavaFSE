import React from 'react';
import officeImg from './assets/office1.jpg';
import './App.css';

function App() {
  // Details of a single main office space object
  const primaryOffice = {
    name: "DBS Premium Suite",
    rent: 75000,
    address: "Block A, Connaught Place, New Delhi"
  };

  // List of other office space objects to loop through
  const officesList = [
    {
      id: 1,
      name: "Regus Co-working Space",
      rent: 45000,
      address: "Sector 62, Noida, Uttar Pradesh"
    },
    {
      id: 2,
      name: "WeWork Executive Cabin",
      rent: 90000,
      address: "Cyber City, Gurugram, Haryana"
    },
    {
      id: 3,
      name: "Innov8 Desk Spaces",
      rent: 55000,
      address: "Saket District Centre, New Delhi"
    },
    {
      id: 4,
      name: "Skootr Managed Workspace",
      rent: 85000,
      address: "Okhla Phase 3, New Delhi"
    }
  ];

  return (
    <div className="App" style={{ fontFamily: 'Arial, sans-serif', padding: '25px', backgroundColor: '#f9f9fb', minHeight: '100vh' }}>
      {/* 1. Heading of the page */}
      <h1 style={{ textAlign: 'center', color: '#1a202c', borderBottom: '2px solid #e2e8f0', paddingBottom: '15px' }}>
        Office Space Rental Dashboard
      </h1>

      {/* Primary Featured Office Space details */}
      <div style={{ maxWidth: '800px', margin: '30px auto', background: '#fff', borderRadius: '12px', boxShadow: '0 8px 16px rgba(0,0,0,0.06)', overflow: 'hidden' }}>
        <h2 style={{ padding: '20px 20px 0 20px', margin: 0, color: '#2d3748' }}>Featured Office Space</h2>

        {/* 2. Attribute to display image of the office space */}
        <div style={{ padding: '20px', textAlign: 'center' }}>
          <img 
            src={officeImg} 
            alt={primaryOffice.name} 
            style={{ width: '100%', maxHeight: '400px', objectFit: 'cover', borderRadius: '8px' }}
          />
        </div>

        {/* 3. Display the details of primaryOffice */}
        <div style={{ padding: '0 20px 20px 20px' }}>
          <h3>{primaryOffice.name}</h3>
          <p><strong>Address:</strong> {primaryOffice.address}</p>
          <p>
            <strong>Rent: </strong>
            <span style={{ color: primaryOffice.rent >= 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
              Rs. {primaryOffice.rent} / month
            </span>
          </p>
        </div>
      </div>

      {/* 4. List of Object and loop through to display more data */}
      <div style={{ maxWidth: '1000px', margin: '40px auto' }}>
        <h2 style={{ borderBottom: '1px solid #e2e8f0', paddingBottom: '10px', color: '#2d3748' }}>
          Other Available Offices
        </h2>

        <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(280px, 1fr))', gap: '20px', marginTop: '20px' }}>
          {officesList.map(office => (
            <div 
              key={office.id} 
              style={{
                background: '#ffffff',
                border: '1px solid #e2e8f0',
                borderRadius: '8px',
                padding: '20px',
                boxShadow: '0 4px 6px rgba(0,0,0,0.02)',
                textAlign: 'left'
              }}
            >
              <h4 style={{ margin: '0 0 10px 0', color: '#2d3748', fontSize: '18px' }}>{office.name}</h4>
              <p style={{ margin: '5px 0', color: '#718096', fontSize: '14px' }}>
                <strong>Address:</strong> {office.address}
              </p>
              <p style={{ margin: '15px 0 0 0', fontSize: '16px' }}>
                <strong>Rent: </strong>
                {/* 5. Color the rent based on threshold (Red if below 60000, Green if above/equal) */}
                <span style={{ color: office.rent >= 60000 ? 'green' : 'red', fontWeight: 'bold' }}>
                  Rs. {office.rent} / month
                </span>
              </p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
