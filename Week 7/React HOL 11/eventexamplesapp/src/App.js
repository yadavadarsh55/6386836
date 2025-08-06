import React, { useState } from "react";
import "./App.css";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [counter, setCounter] = useState(0);

  // Multiple methods for Increase
  const increment = () => setCounter((prev) => prev + 1);
  const sayHello = () => alert("Hello! This is a static message.");
  const handleIncrease = () => {
    increment();
    sayHello();
  };

  const handleDecrease = () => setCounter((prev) => prev - 1);

  // Say Welcome button
  const sayWelcome = (msg) => alert(msg);

  // Synthetic event handler
  const handleOnPress = () => alert("I was clicked");

  return (
    <div className="App">
      <h1>Event Examples App</h1>
      <div style={{ margin: "1rem" }}>
        <h2>Counter: {counter}</h2>
        <button onClick={handleIncrease}>Increment</button>
        <button onClick={handleDecrease} style={{ marginLeft: "1rem" }}>
          Decrement
        </button>
      </div>
      <div style={{ margin: "1rem" }}>
        <button onClick={() => sayWelcome("welcome")}>Say Welcome</button>
      </div>
      <div style={{ margin: "1rem" }}>
        <button onClick={handleOnPress}>OnPress</button>
      </div>
      <CurrencyConvertor />
    </div>
  );
}

export default App;
