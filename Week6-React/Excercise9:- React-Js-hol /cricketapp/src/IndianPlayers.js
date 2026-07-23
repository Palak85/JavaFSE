import React from 'react';

const IndianPlayers = () => {
  const indianPlayers = ['Dhoni', 'Kohli', 'Rohit', 'Rahul', 'Jadeja', 'Hardik'];

  // Destructuring array elements into separate variables
  const [p1, p2, p3, p4, p5, p6] = indianPlayers;

  // Grouping into Odd and Even positions
  const oddPlayers = [p1, p3, p5];  // 1st (Dhoni), 3rd (Rohit), 5th (Jadeja)
  const evenPlayers = [p2, p4, p6]; // 2nd (Kohli), 4th (Rahul), 6th (Hardik)

  // Declare T20 and Ranji Trophy arrays
  const T20players = ['Virat Kohli', 'Rohit Sharma', 'Hardik Pandya'];
  const RanjiTrophyPlayers = ['Abhimanyu Easwaran', 'Sarfaraz Khan', 'Yash Dayal'];

  // Merge using ES6 Spread operator
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div style={{ padding: '20px', background: '#eaf2f8', borderRadius: '8px', margin: '20px 0' }}>
      <h2>Indian Players Details</h2>

      <h3>Odd Team Players (Destructured)</h3>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Even Team Players (Destructured)</h3>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

      <h3>Merged T20 & Ranji Trophy Squads (Spread Merge)</h3>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
