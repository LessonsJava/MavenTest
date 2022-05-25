package api.connection;

import io.restassured.specification.RequestSpecification;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

import static io.restassured.RestAssured.given;

public class RestAssuredConnection implements Connection {
    private String basePath = "http://77.50.236.203:4880";

    @Override
    public CloseableHttpClient getClient() {
        return null;
    }

    public RequestSpecification getSpecification() {
        return given().baseUri(basePath).when();
    }
}
