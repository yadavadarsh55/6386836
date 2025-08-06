import React from "react";

const players = [
  { name: "Virat Kohli", score: 95 },
  { name: "Rohit Sharma", score: 88 },
  { name: "KL Rahul", score: 65 },
  { name: "Shikhar Dhawan", score: 72 },
  { name: "Rishabh Pant", score: 55 },
  { name: "Hardik Pandya", score: 80 },
  { name: "Ravindra Jadeja", score: 60 },
  { name: "Jasprit Bumrah", score: 45 },
  { name: "Bhuvneshwar Kumar", score: 78 },
  { name: "Yuzvendra Chahal", score: 68 },
  { name: "Mohammed Shami", score: 90 },
];

export function ListofPlayers() {
  const players70 = players.filter((player) => player.score <= 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((item) => (
          <li key={item.name}>
            Mr. {item.name} <span>({item.score})</span>
          </li>
        ))}
      </ul>
      <h2>Players with Score ≤ 70</h2>
      <ul>
        {players70.map((item) => (
          <li key={item.name}>
            Mr. {item.name} <span>({item.score})</span>
          </li>
        ))}
      </ul>
    </div>
  );
}
