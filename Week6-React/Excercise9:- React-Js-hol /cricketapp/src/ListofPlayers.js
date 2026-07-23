import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Sachin', score: 120 },
    { name: 'Dhoni', score: 95 },
    { name: 'Kohli', score: 80 },
    { name: 'Rohit', score: 110 },
    { name: 'Dhawan', score: 65 },
    { name: 'Rahul', score: 50 },
    { name: 'Jadeja', score: 75 },
    { name: 'Hardik', score: 60 },
    { name: 'Bumrah', score: 10 },
    { name: 'Shami', score: 15 },
    { name: 'Ashwin', score: 45 }
  ];

  // Using arrow function to filter players with scores >= 70
  const highScorers = players.filter(p => p.score >= 70);

  // Using arrow function to filter players with scores below 70
  const lowScorers = players.filter(p => p.score < 70);

  return (
    <div style={{ padding: '20px', background: '#f5f5f5', borderRadius: '8px', margin: '20px 0' }}>
      <h2>List of Players</h2>

      <h3>All Players (using map)</h3>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>

      <h3>Filtered Players (Scores &gt;= 70)</h3>
      <ul>
        {highScorers.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>

      <h3>Filtered Players (Scores below 70)</h3>
      <ul>
        {lowScorers.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
