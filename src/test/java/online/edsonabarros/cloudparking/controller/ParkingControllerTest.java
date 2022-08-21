package online.edsonabarros.cloudparking.controller;

import io.restassured.RestAssured;
import online.edsonabarros.cloudparking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // subir teste em porta aleatoria
class ParkingControllerTest {


    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void  setUpTeste(){
        System.out.println(randomPort);
        RestAssured.port = randomPort;
    }

    @Test
    void  whenfindAllcheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(200);
               // .body("license[1]", Matchers.equalTo("DMD-1111")); //checar se o campo license (array) tem um equals

    }



    @Test
    void whenCreateThenCheckIsCreated() {

        var createDTO = new ParkingCreateDTO();

        createDTO.setColor("AMARELO");
        createDTO.setLicense("ARA-5555");
        createDTO.setModel("BRASILA");
        createDTO.setState("SP");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("color", Matchers.equalTo("AMARELO"));
    }
}