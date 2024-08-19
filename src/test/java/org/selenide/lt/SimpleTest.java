package org.selenide.lt;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class SimpleTest {
  @Test
  void search() {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();

    $$("#user-tags .tag").shouldHave(sizeGreaterThan(8));
    $$("#selenide-users .user").shouldHave(sizeGreaterThan(20));
  }
}
