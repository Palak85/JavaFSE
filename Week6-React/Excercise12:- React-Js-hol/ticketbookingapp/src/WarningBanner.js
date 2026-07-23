import React from 'react';

const WarningBanner = ({ showWarning }) => {
  // If showWarning is false, returning null prevents the component from rendering.
  if (!showWarning) {
    return null;
  }

  return (
    <div style={{ padding: '12px', background: '#fff3cd', color: '#856404', borderRadius: '4px', margin: '15px 0', border: '1px solid #ffeeba' }}>
      <strong>Notice:</strong> You are currently browsing in Guest Mode. Please log in above to unlock ticket bookings.
    </div>
  );
};

export default WarningBanner;
