import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [convertedEuros, setConvertedEuros] = useState(null);

  const [eurosInput, setEurosInput] = useState('');
  const [convertedRupees, setConvertedRupees] = useState(null);

  // Conversion rate: 1 EUR = 90 INR
  const handleSubmitINRtoEUR = (e) => {
    e.preventDefault();
    const result = parseFloat(rupees) / 90;
    setConvertedEuros(isNaN(result) ? 0 : result.toFixed(2));
  };

  const handleSubmitEURtoINR = (e) => {
    e.preventDefault();
    const result = parseFloat(eurosInput) * 90;
    setConvertedRupees(isNaN(result) ? 0 : result.toFixed(2));
  };

  return (
    <div style={{ padding: '20px', background: '#fff', borderRadius: '8px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', marginTop: '30px' }}>
      <h2 style={{ borderBottom: '2px solid #333', paddingBottom: '10px', color: '#1a202c' }}>
        Currency Converter
      </h2>

      {/* INR to EUR conversion */}
      <div style={{ marginBottom: '30px' }}>
        <h3>Convert Indian Rupees to Euros</h3>
        <form onSubmit={handleSubmitINRtoEUR}>
          <div style={{ marginBottom: '10px' }}>
            <label style={{ display: 'block', marginBottom: '5px' }}>Amount in Rupees (INR):</label>
            <input 
              type="number"
              value={rupees}
              onChange={(e) => setRupees(e.target.value)}
              placeholder="Enter Rupees"
              style={{ padding: '8px', width: '220px', fontSize: '14px', border: '1px solid #ccc', borderRadius: '4px' }}
              id="inr-input"
              required
            />
          </div>
          <button 
            type="submit"
            style={{ padding: '10px 20px', background: '#28a745', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
            id="inr-to-eur-btn"
          >
            Convert to EUR
          </button>
        </form>
        {convertedEuros !== null && (
          <p style={{ fontSize: '16px', fontWeight: 'bold', marginTop: '10px' }}>
            Result: <span style={{ color: 'green' }}>€ {convertedEuros}</span>
          </p>
        )}
      </div>

      {/* EUR to INR conversion */}
      <div>
        <h3>Convert Euros to Indian Rupees</h3>
        <form onSubmit={handleSubmitEURtoINR}>
          <div style={{ marginBottom: '10px' }}>
            <label style={{ display: 'block', marginBottom: '5px' }}>Amount in Euros (EUR):</label>
            <input 
              type="number"
              value={eurosInput}
              onChange={(e) => setEurosInput(e.target.value)}
              placeholder="Enter Euros"
              style={{ padding: '8px', width: '220px', fontSize: '14px', border: '1px solid #ccc', borderRadius: '4px' }}
              id="eur-input"
              required
            />
          </div>
          <button 
            type="submit"
            style={{ padding: '10px 20px', background: '#007bff', color: '#fff', border: 'none', borderRadius: '4px', cursor: 'pointer' }}
            id="eur-to-inr-btn"
          >
            Convert to INR
          </button>
        </form>
        {convertedRupees !== null && (
          <p style={{ fontSize: '16px', fontWeight: 'bold', marginTop: '10px' }}>
            Result: <span style={{ color: 'blue' }}>Rs. {convertedRupees}</span>
          </p>
        )}
      </div>
    </div>
  );
};

export default CurrencyConvertor;
