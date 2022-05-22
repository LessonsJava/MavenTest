package patterns.pageObjects;

import com.codeborne.selenide.SelenideElement;
import exampleClasses.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MailPage {
      public SelenideElement newsItemsTitle() {
        return $("[data-testid=\"news-item-title\"]");
    }

    public SelenideElement loginField() {
          return $("");
    }

    public SelenideElement passwordField() {
          return $("");
    }

    public SelenideElement enterButton() {
        return $("");
    }

    public MailPage inputLogin(String login) {
          loginField().shouldBe(visible).setValue(login);
          return this;
    }

    public MailPage inputPassword(String password) {
          passwordField().shouldBe(visible).setValue(password);
          return this;
    }

    public void pressEnter() {
          enterButton().shouldBe(visible).click();
    }

    public void login(String login, String password) {
        loginField().shouldBe(visible).setValue(login);
        passwordField().shouldBe(visible).setValue(password);
        enterButton().shouldBe(visible).click();
    }

    public void login(User user) {
        loginField().shouldBe(visible).setValue(user.login);
        passwordField().shouldBe(visible).setValue(user.password);
        enterButton().shouldBe(visible).click();
    }

    public SelenideElement newsTab() {
        return $("");
    }

    public SelenideElement sportTab() {
        return $("");
    }

    public SelenideElement ladyTab() {
        return $("");
    }

    public  SelenideElement city() {
        return $("");
    }

    public static class NewsPage {
          public SelenideElement newsTab() {
              return $("");
          }

          public SelenideElement sportTab() {
              return $("");
          }

          public SelenideElement ladyTab() {
              return $("");
          }
    }

    class Weather {
          public  SelenideElement city() {
              return $("");
          }
    }
}
