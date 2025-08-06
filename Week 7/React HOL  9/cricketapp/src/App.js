import "./App.css";
import { ListofPlayers } from "./components/ListofPlayers";
import { IndianPlayers } from "./components/IndianPlayers";

import React, { useState } from "react";

function App() {
  // flag variable to toggle between components
  const [flag, setFlag] = useState(true);

  const handleToggle = () => setFlag((prev) => !prev);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Cricket App</h1>
        <button onClick={handleToggle} style={{ marginBottom: "20px" }}>
          {flag ? "Show Indian Players" : "Show List of Players"}
        </button>
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </header>
    </div>
  );
}

export default App;
