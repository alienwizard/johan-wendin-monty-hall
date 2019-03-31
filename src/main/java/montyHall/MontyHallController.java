package montyHall;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/monty-hall", produces = "application/json; charset=UTF-8")
public class MontyHallController {

    @PostMapping
    public ResponseEntity runMontyHallSimulation(@RequestBody MontyHallSimulation gameSetup) {
        MontyHallSimulation simulation = new MontyHallSimulation(gameSetup.simulations, gameSetup.changeDoor);

        return ResponseEntity.ok(simulation.runSimulation());
    }
}
