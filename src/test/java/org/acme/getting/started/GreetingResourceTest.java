package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    @Order(1)
    public void hello() {
        when()
                .post("/hello/enable")
                .then()
                .statusCode(204);

        when()
                .get("/client")
                .then()
                .statusCode(200)
                .body(is("Client got: Hello, World!"));
    }

}