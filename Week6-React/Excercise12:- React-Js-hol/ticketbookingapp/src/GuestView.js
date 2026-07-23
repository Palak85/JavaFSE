import React from 'react';

const GuestView = () => {
  const flights = [
    { id: 1, flightNo: 'AI-101', source: 'Delhi', destination: 'Mumbai', departure: '08:00 AM' },
    { id: 2, flightNo: '6E-502', source: 'Bengaluru', destination: 'Delhi', departure: '11:30 AM' },
    { id: 3, flightNo: 'UK-812', source: 'Mumbai', destination: 'Chennai', departure: '03:15 PM' }
  ];

  return (
    <div style={{ padding: '20px', background: '#f8f9fa', borderRadius: '8px', marginTop: '20px', border: '1px solid #ddd' }}>
      <h3 style={{ color: '#e0a800', marginTop: 0 }}>Guest Workspace - Browsing Mode</h3>
      <p style={{ color: '#721c24', fontWeight: 'bold' }}>
        * Please Log In to book your flight tickets. Currently viewing in read-only mode.
      </p>
      <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '15px' }}>
        <thead>
          <tr style={{ background: '#343a40', color: '#fff' }}>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #dee2e6' }}>Flight No</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #dee2e6' }}>Source</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #dee2e6' }}>Destination</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #dee2e6' }}>Departure</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #dee2e6' }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(f => (
            <tr key={f.id} style={{ borderBottom: '1px solid #dee2e6' }}>
              <td style={{ padding: '10px', border: '1px solid #dee2e6' }}>{f.flightNo}</td>
              <td style={{ padding: '10px', border: '1px solid #dee2e6' }}>{f.source}</td>
              <td style={{ padding: '10px', border: '1px solid #dee2e6' }}>{f.destination}</td>
              <td style={{ padding: '10px', border: '1px solid #dee2e6' }}>{f.departure}</td>
              <td style={{ padding: '10px', border: '1px solid #dee2e6' }}>
                <button disabled style={{ padding: '6px 12px', borderRadius: '4px', background: '#ccc', border: 'none', cursor: 'not-allowed', color: '#666' }}>
                  Book Disabled
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default GuestView;
