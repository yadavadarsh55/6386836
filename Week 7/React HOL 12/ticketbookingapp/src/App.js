import logo from './logo.svg';
import './App.css';
import { LoggedIn } from './components/LoggedIn';
import { LoggedOut } from './components/LoggedOut';
import React, { useState } from 'react';

function App() {
  const [login, setLogin] = useState(false);

  const handleLogin = () => {
    setLogin(true);
  };
  const handleLogout = () => {
    setLogin(false);
  };
  return (
    <div className="App">
      {
        login ? (
          <LoggedIn handleLogout={handleLogout} />
        ) : (
          <LoggedOut handleLogin={handleLogin} />
        )
      }
    </div>
  );
}

export default App;
