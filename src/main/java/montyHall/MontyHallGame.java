package montyHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MontyHallGame {
    ArrayList<DoorContent> doors = new ArrayList();
    public Integer playerChoice;
    public Integer doorWithCar;

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
        List<Integer> doorsLeft = intStream.filter(door -> door != playerChoice && door != doorWithCar)
            .boxed()
            .collect(Collectors.toList());


        return doorsLeft.get(new Random().nextInt(doorsLeft.size()));
    }

    private Integer changePlayerChoice() throws Exception {
        int revealedDoor = revealDoor();
        IntStream intStream = IntStream.range(0, doors.size());


        Integer doorLeft = intStream.filter(doorIndex -> doorIndex != playerChoice && doorIndex != revealedDoor)
                    .findFirst().orElseThrow(() -> new Exception("Something went wrong"));

        return doorLeft;

    }

    public GameResult runGame(Boolean changeDoor) {

        populateDoors();
        playerChoice = new Random().nextInt(3);

        if (changeDoor) {
            try {
                playerChoice = changePlayerChoice();
            } catch (Exception exception) {
                // This wont happen
            }
        }

        if (playerChoice == doorWithCar) {
            return GameResult.WIN;
        }

        return GameResult.LOSS;
    }
}
