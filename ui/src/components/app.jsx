import React from 'react';
import Game from './gameArea/game';

import './app.scss';

export default function App() {
  return (
    <div>
      <main>
        <h1>Monty hall</h1>
        <Game></Game>
      </main>
    </div>
  );
}