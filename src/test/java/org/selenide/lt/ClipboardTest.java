package org.selenide.lt;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clipboard;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ClipboardTest {
  @Test
  @Disabled
  void canCheckClipboardContent() {
    open("https://selenide.org/test-page/clipboard.html");
    $("#text-input").val("Hello LambdaTest!");
    $("#copy-button").click();
    clipboard().shouldHave(content("Hello LambdaTest!"));
  }
}
