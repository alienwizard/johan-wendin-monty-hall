import React, {useState} from 'react';
import GameForm from './gameForm/gameForm';
import GameResult from './gameResult/gameResult';
import {post} from '../../utils/request';

export default function Game() {
  const [simulationResult, setSimulationResult] = useState(undefined);

  function startSimulation(options) {
    event.preventDefault();
    post('/api/monty-hall', {body: options})
      .then((result) => {
        setSimulationResult(result);
      });
  }

  return (
    <div>
      <GameForm onSubmit={startSimulation}></GameForm>
      <GameResult result={simulationResult}></GameResult>
    </div>
  );
}