import './App.css';
import Home from './components/home';
import Number from './components/Number'
import Word from './components/Word'
import Color from './components/Color'
import React from "react";
import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <h1>Routing Example</h1>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/:number" element={<Number />} />
        <Route path="/:word" element={<Word />} />
        <Route path="/:word/:textColor/:backgroundColor" element={<Color />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
