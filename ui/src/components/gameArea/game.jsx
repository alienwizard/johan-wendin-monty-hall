import React, {useState} from 'react';
import GameForm from './gameForm/gameForm';
import GameResult from './gameResult/gameResult';
import { post } from '../../utils/request';

export const SimulationContext = React.createContext();

export default function Game() {
  const [simulationResult, setSimulationResult] = useState(undefined);

  function startSimulation(options) {
    console.log('startSimulation', event.target.value, event.target);
    event.preventDefault();
    post('/api/monty-hall', {body: options})
      .then((result) => {
        setSimulationResult(result);
      });
  }

  return (
    <SimulationContext.Provider>
      <GameForm onSubmit={startSimulation}></GameForm>
      <GameResult result={simulationResult}></GameResult>
    </SimulationContext.Provider>
  );
}