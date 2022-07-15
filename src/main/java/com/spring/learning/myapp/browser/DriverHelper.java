package com.spring.learning.myapp.browser;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class DriverHelper {
    @Getter
    private WebDriver driver;

    @Bean
    public WebDriver initiateChrome() {
        log.info("starting chrome driver...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        return driver;
    }
}
