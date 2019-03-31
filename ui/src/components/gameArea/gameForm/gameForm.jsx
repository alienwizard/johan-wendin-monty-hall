import React, {useState} from 'react';
import PropTypes from 'prop-types';


import './gameForm.scss';

export default function GameForm({onSubmit}) {
  const [changeDoor, setDoorChange] = useState(false);
  const [simulations, setSimulations] = useState(1);

  function handleInputChanged(event) {
    const {target} = event;
    const value = target.type === 'checkbox' ? target.checked : target.value;

    if (target.name === 'openDoor') {
      setDoorChange(value);
    } else if (target.name === 'simulations') {
      setSimulations(target.value);
    }
  }

  return (
    <div className="game-area__form">
      <form onSubmit={() => onSubmit(JSON.stringify({simulations, changeDoor}))}>
        <div className="game-area__form-input-group">
          <label htmlFor="simulations" >Games to run: </label>
          <input required name="simulations" type="number" value={simulations} onChange={handleInputChanged}></input>
        </div>
        <div className="game-area__form-input-group">
          <label htmlFor="openDoor">Do you change your chosen door?</label>
          <input name="openDoor" type="checkbox" checked={changeDoor} onChange={handleInputChanged}></input>
        </div>
        <input type="submit"></input>
      </form>
    </div>
  );
}

GameForm.propTypes = {
  onSubmit: PropTypes.func
};
