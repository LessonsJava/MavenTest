package api.connection;

import io.restassured.specification.RequestSpecification;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

public class HttpClientConnection implements Connection{
    @Override
    public CloseableHttpClient getClient() {
        //Напишите здесь ваш код
        //Должен возвращаться готовый для теста Http клиент

        return null;
    }

    @Override
    public RequestSpecification getSpecification() {
        return null;
    }
}
