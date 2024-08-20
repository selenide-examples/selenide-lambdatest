package org.selenide.lt;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.cookie;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static com.codeborne.selenide.WebDriverConditions.numberOfWindows;
import static com.codeborne.selenide.WebDriverConditions.title;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class WebdriverConditionsTest {
  @Test
  void search() {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();

    webdriver().shouldHave(url("https://selenide.org/users.html"));
    webdriver().shouldHave(urlStartingWith("https://selenide.org"));
    webdriver().shouldHave(urlContaining("selenide.org/users"));
    webdriver().shouldHave(currentFrameUrl("https://selenide.org/users.html"));
    webdriver().shouldHave(numberOfWindows(1));
    webdriver().shouldHave(title("Selenide users"));
    webdriver().shouldNotHave(cookie("session", "sid-12345"));
    webdriver().shouldNotHave(cookie("session"));
  }
}
