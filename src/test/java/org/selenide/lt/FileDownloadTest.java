package org.selenide.lt;

import com.codeborne.selenide.FileDownloadMode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.CDP;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.FileDownloadMode.HTTPGET;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.FileFilters.withExtension;
import static org.assertj.core.api.Assertions.assertThat;

public class FileDownloadTest {
  @Test
  void downloadFile_using_httpGet() {
    checkDownload(HTTPGET);
  }

  @Test
  @Disabled
  void downloadFile_using_cdp() {
    checkDownload(CDP);
  }

  @Test
  @Disabled
  void downloadFile_using_folder() {
    checkDownload(FOLDER);
  }

  @Test
  @Disabled
  void downloadFile_using_proxy() {
    checkDownload(PROXY);
  }

  static void checkDownload(FileDownloadMode method) {
    open("https://selenide.org/test-page/download.html");
    File file = $(byText("hello-world.txt")).download(using(method).withFilter(withExtension("txt")));
    assertThat(file).hasName("hello-world.txt");
    assertThat(file).content().isEqualTo("Hello, world!");
  }
}
