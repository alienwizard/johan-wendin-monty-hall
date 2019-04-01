package montyHall;

public class MontyHallSimulation {
    public Integer simulations;
    public Boolean changeDoor;

    // for deserialisation
    public MontyHallSimulation() {}

    public MontyHallSimulation(Integer simulations, Boolean changeDoor) {
        this.simulations = simulations;
        this.changeDoor = changeDoor;
    }

        public MontyHallSimulationResult runSimulation() {
        int totalWins = 0;
        int totalLosses = 0;
        int totalGames = 0;

        for (int i = 0; i < simulations; i++) {
            MontyHallGame game = new MontyHallGame();
            GameResult result = game.runGame(changeDoor);

            if (result == GameResult.WIN) {
                totalWins++;
            } else {
                totalLosses++;
            }

            totalGames++;
        }

        return new MontyHallSimulationResult(totalWins, totalLosses, totalGames);
    }

}
