package test;

import api.connection.HttpClientConnection;
import api.connection.RestAssuredConnection;
import api.integrationSubsystems.performance.PerformanceAPI;
import api.integrationSubsystems.performance.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerformanceTest {


    @Test
    @Tag("users")
    void getUsersTest() {
        PerformanceAPI performanceAPI = new PerformanceAPI();

        User[] users = performanceAPI.setConnection(new RestAssuredConnection())
                .getUsers()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getBody()
                .as(User[].class);

        assertNotNull(users);

        assertTrue(users.length > 0);
    }

    @Test
    @Tag("users")
    void getUsersHttpClientTest() throws IOException {
        PerformanceAPI performanceAPI = new PerformanceAPI().setConnection(new HttpClientConnection());

        performanceAPI.getHttpClientUsers();

    }
}
