package org.selenide.lt;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Map;

public class TestSetup implements BeforeAllCallback {
  /**
   * See all <a href="https://www.lambdatest.com/support/docs/selenium-four-capabilities/">LambdaTest settings</a>
   */
  @Override
  public void beforeAll(ExtensionContext context) {
    Configuration.remote = "https://hub.lambdatest.com/wd/hub";
    Configuration.browserCapabilities.setCapability("LT:Options", Map.of(
        "user", System.getenv("LT_USERNAME"),
        "accessKey", System.getenv("LT_ACCESS_KEY"),
        "seCdp", true,
        "selenium_version", "4.23.0"
    ));
  }
}
