package test;

import com.codeborne.selenide.Configuration;
import exampleClasses.*;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import patterns.pageObjects.MailPage;

import javax.net.ssl.SSLContext;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static exampleClasses.CatFactory.createCat;
import static exampleClasses.CatType.SIMPLE;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass {
    @Test
    void singletonTest() {
        Singleton s = Singleton.getInstance();

        System.out.println(s);
    }

    @Test
    void builderTest() {
        Cat cat = CatBuilder.create()
                .setOwner("Костя")
                .setCatColor("Чёрно-белый")
                .setAge(6)
                .build();

        System.out.println();
    }

    @Test
    void factoryTest() {
        Cat cat = createCat(SIMPLE);

        System.out.println();
    }

    @Test
    void test() {
        String str = "Первый тест";
        assertEquals("Первый тест", str, "Уже не первый тест");
    }

    @Test
    @Tag("tag")
    void testNegative() {
        //Arrange
        Configuration.reportsFolder = "test-result/reports";
        Configuration.screenshots = true;
        MailPage mailPage = new MailPage();
        User aydar = new User();
        aydar.login = "Aydar@mail.ru";
        aydar.password = "Дико секретный пароль";

        step("Открыть страницу mail.ru", () -> {
            open("https://mail.ru/?from=logout");
        });

        mailPage.login(aydar);

        //Act
        step("Должен появиться заголовок новости", () -> {
            String text = mailPage.newsItemsTitle()
                    .shouldBe(visible)
                    .getText();

//            new MailPage.NewsPage().newsTab().shouldBe(visible).click();
            //Assert
            assertTrue(text.contains("Медведч1ук"), "Текст на страничке был такой: " + text);
        });
//        mailPage.inputLogin("Aydar@mail.ru")
//                .inputPassword("Дико секретный пароль")
//                .pressEnter();


//
//        mailPage.login("Aydar@mail.ru", "Дико секретный пароль");
//
//        mailPage.newsTab().click();


    }

    @Test
    void catTest() {
        Cat cat = new Cat();
        assertEquals("Мяу", cat.getVoice());
    }

    @Test
    void rest() {
        given()
                .basePath("")
                .when()
                .get("https://mail.ru/")
                .then()
                .statusCode(200);
    }

    @Test
    void apacheClientTest() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(new TrustAllStrategy()).build();

        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);


        HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .build();

        HttpClient client = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .disableRedirectHandling()
                .setDefaultCookieStore(new BasicCookieStore())
                .build();

        ClassicHttpRequest request = new HttpGet("https://mail.ru/");

        HttpResponse response = client.execute(request);

        Assertions.assertEquals(200, response.getCode());
    }
}
