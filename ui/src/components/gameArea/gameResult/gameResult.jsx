import React from 'react';
import PropTypes from 'prop-types';

export default function GameResult({result}) {
  if (result) {
    const {totalGames, totalWins, totalLosses} = result;
    return (
      <div className='game-area__result'>
        <h2>Total Games: {totalGames}</h2>
        <h2>Total Wins: {totalWins}</h2>
        <h2>Total Losses: {totalLosses}</h2>
      </div>
    );
  } else {
    return (
      <div>
        <h2>Submit form to simulate Monty hall</h2>
      </div>);
  }
}

GameResult.propTypes = {
  result: PropTypes.object
};