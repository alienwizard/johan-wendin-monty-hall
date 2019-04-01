package montyHall;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MontyHallGameTest {

    @Test
    public void revealDoor_should_never_reveal_car() {
        MontyHallGame testGame = new MontyHallGame();
        testGame.populateDoors();
        testGame.playerChoice = new Random().nextInt(3);

        for (int i = 0; i < 1000; i++) {
            Integer revealedDoor = testGame.revealDoor();
            assertNotEquals(revealedDoor, testGame.doorWithCar);
        }
    }
}