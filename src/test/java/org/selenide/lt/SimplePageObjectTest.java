package org.selenide.lt;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SimplePageObjectTest {
  @BeforeEach
  void setUp() {
    open("https://selenide.org/users.html");
  }

  @Test
  void showsAllKnownSelenideUsers() {
    SelenideUsersPage page = new SelenideUsersPage();
    page.users().shouldHave(sizeGreaterThan(40));
  }

  @Test
  void canFilterByTag() {
    SelenideUsersPage page = new SelenideUsersPage();
    page.filterByTag("usa");
    page.users().shouldHave(sizeLessThan(40));
  }

  private static class SelenideUsersPage {
    public ElementsCollection users() {
      return $$("#selenide-users .user:not(.hidden)");
    }

    public void filterByTag(String tag) {
      $("#user-tags").find(byText(tag)).click();
    }
  }
}
