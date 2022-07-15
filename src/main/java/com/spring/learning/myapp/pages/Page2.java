package com.spring.learning.myapp.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Page2 {
    private final WebDriver driver;

    public String openWirtualPolskaPage() {
        driver.navigate().to("http://wp.pl");
        return driver.getTitle();
    }

}
