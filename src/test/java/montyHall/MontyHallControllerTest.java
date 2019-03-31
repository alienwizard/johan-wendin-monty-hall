package montyHall;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.restassured.RestAssured;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;

public class MontyHallControllerTest {
    MontyHallController montyHall = new MontyHallController();

    @Test
    public void runMontyHallSimulation() {
        MontyHallSimulation setup = new MontyHallSimulation(10, true);
        ResponseEntity respone = montyHall.runMontyHallSimulation(setup);

        RestAssured
                .given()
                .body("{simulations: 200, changeDoor: true}")
                .port(8080)
                .post("/api/monty-hall")
                .then()
                .assertThat().statusCode(200);

        // ResponseEntity expectedResponse = new ResponseEntity(new HttpStatus(200));
    }
}