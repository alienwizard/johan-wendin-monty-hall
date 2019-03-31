import React from 'react';
import ShallowRenderer from 'react-test-renderer/shallow';
import GameResult from './gameResult';

describe('GameResult', () => {
  it('Should show tip when no result is present', () => {
    const renderer = new ShallowRenderer();
    renderer.render(<GameResult />);

    const result = renderer.getRenderOutput();

    expect(result.props.children).toEqual(<h2>Submit form to simulate Monty hall</h2>);
  });
});