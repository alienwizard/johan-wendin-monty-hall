package montyHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MontyHallSimulation {
    public Integer simulations;
    public Boolean changeDoor;

    private class MontyHallGame {
        ArrayList<DoorContent> doors = new ArrayList();
        Integer playerChoice;
        Integer doorWithCar;

        void populateDoors() {
            doorWithCar = new Random().nextInt(3);

            for (int i = 0; i < 3; i++) {
                if (i == doorWithCar) {
                    doors.add(DoorContent.CAR);
                } else {
                    doors.add(DoorContent.GOAT);
                }
            }
        }

        Integer revealDoor() {
            IntStream intStream = IntStream.range(0, doors.size());
            List<Integer> doorsLeft = intStream.filter(i -> i != playerChoice && i != doorWithCar)
                .boxed()
                .collect(Collectors.toList());


            return doorsLeft.get(new Random().nextInt(doorsLeft.size()));
        }

        public GameResult run() {
            // Setup game
            populateDoors();
            playerChoice = new Random().nextInt(3);
            int revealedDoor = revealDoor();

            if (changeDoor) {
                IntStream intStream = IntStream.range(0, doors.size());
                List<Integer> doorsLeft = intStream.filter(i -> i != playerChoice && i != revealedDoor)
                        .boxed()
                        .collect(Collectors.toList());

                playerChoice = doorsLeft.get(new Random().nextInt(doorsLeft.size()));
            }

            if (playerChoice == doorWithCar) {
                return GameResult.WIN;
            }

            return GameResult.LOSS;
        }
    }

    // for deserialisation
    public MontyHallSimulation() {}

    public MontyHallSimulation(Integer simulations, Boolean changeDoor) {
        this.simulations = simulations;
        this.changeDoor = changeDoor;
    }

        public MontyHallSimulationResult runSimulation() {
        ArrayList<MontyHallGame> games = new ArrayList();
        int totalWins = 0;
        int totalLosses = 0;
        int totalGames = 0;
        for (int i = 0; i < simulations; i++) {
            MontyHallGame game = new MontyHallGame();
            GameResult result = game.run();

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
