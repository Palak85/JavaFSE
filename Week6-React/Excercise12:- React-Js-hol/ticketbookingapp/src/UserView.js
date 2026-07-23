import React, { useState } from 'react';

const UserView = () => {
  const [bookedFlight, setBookedFlight] = useState(null);

  const flights = [
    { id: 1, flightNo: 'AI-101', source: 'Delhi', destination: 'Mumbai', departure: '08:00 AM' },
    { id: 2, flightNo: '6E-502', source: 'Bengaluru', destination: 'Delhi', departure: '11:30 AM' },
    { id: 3, flightNo: 'UK-812', source: 'Mumbai', destination: 'Chennai', departure: '03:15 PM' }
  ];

  const handleBook = (flightNo) => {
    setBookedFlight(flightNo);
    alert(`Success! Ticket booked for flight ${flightNo}`);
  };

  return (
    <div style={{ padding: '20px', background: '#e8f5e9', borderRadius: '8px', marginTop: '20px', border: '1px solid #c8e6c9' }}>
      <h3 style={{ color: '#2e7d32', marginTop: 0 }}>User Dashboard - Flight Booking Active</h3>
      <p style={{ color: '#2e7d32', fontWeight: 'bold' }}>
        Welcome back! You can now book tickets below.
      </p>

      {bookedFlight && (
        <div style={{ padding: '10px', background: '#a5d6a7', borderRadius: '4px', margin: '10px 0', fontWeight: 'bold', color: '#1b5e20' }} id="booking-confirmation">
          Latest Booking Confirmed: {bookedFlight}
        </div>
      )}

      <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '15px' }}>
        <thead>
          <tr style={{ background: '#2e7d32', color: '#fff' }}>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #c8e6c9' }}>Flight No</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #c8e6c9' }}>Source</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #c8e6c9' }}>Destination</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #c8e6c9' }}>Departure</th>
            <th style={{ padding: '10px', textAlign: 'left', border: '1px solid #c8e6c9' }}>Action</th>
          </tr>
        </thead>
        <tbody>
          {flights.map(f => (
            <tr key={f.id} style={{ borderBottom: '1px solid #c8e6c9' }}>
              <td style={{ padding: '10px', border: '1px solid #c8e6c9' }}>{f.flightNo}</td>
              <td style={{ padding: '10px', border: '1px solid #c8e6c9' }}>{f.source}</td>
              <td style={{ padding: '10px', border: '1px solid #c8e6c9' }}>{f.destination}</td>
              <td style={{ padding: '10px', border: '1px solid #c8e6c9' }}>{f.departure}</td>
              <td style={{ padding: '10px', border: '1px solid #c8e6c9' }}>
                <button 
                  onClick={() => handleBook(f.flightNo)} 
                  style={{ padding: '6px 12px', borderRadius: '4px', background: '#2e7d32', color: '#fff', border: 'none', cursor: 'pointer', fontWeight: 'bold' }}
                  className="book-btn"
                >
                  Book Ticket
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserView;
