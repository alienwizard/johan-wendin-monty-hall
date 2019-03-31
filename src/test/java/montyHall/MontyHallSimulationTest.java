package montyHall;

import org.junit.Test;

import static org.junit.Assert.*;

public class MontyHallSimulationTest {
    @Test
    public void it_should_run_a_simulation_a_given_number_of_times() {
        MontyHallSimulation simulation = new MontyHallSimulation(5, true);

        MontyHallSimulationResult result = simulation.runSimulation();

        assertEquals(Integer.valueOf(5), result.totalGames);
    }

}