import React from "react";

const T20Players = [
  "First Player",
  "Second Player",
  "Third Player",
  "Fourth Player",
  "Fifth Player",
  "Sixth Player",
];
const RanjiTrophyPlayers = [
  "Seventh Player",
  "Eighth Player",
  "Ninth Player",
  "Tenth Player",
  "Eleventh Player",
  "Twelfth Player",
];

const mergedPlayers = [...T20Players, ...RanjiTrophyPlayers];

function OddPlayers({ players }) {
  // Odd indices: 0,2,4,6,8,10
  const oddPlayers = players.filter((_, idx) => idx % 2 === 0);
  return (
    <div>
      <h3>Odd Numbered Players</h3>
      <ul>
        {oddPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

function EvenPlayers({ players }) {
  // Even indices: 1,3,5,7,9,11
  const evenPlayers = players.filter((_, idx) => idx % 2 === 1);
  return (
    <div>
      <h3>Even Numbered Players</h3>
      <ul>
        {evenPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export function IndianPlayers() {
  return (
    <div>
      <OddPlayers players={mergedPlayers} />
      <EvenPlayers players={mergedPlayers} />
      <h3>Merged Players List</h3>
      <ul>
        {mergedPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
}
