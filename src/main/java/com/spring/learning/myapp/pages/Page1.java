package com.spring.learning.myapp.pages;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Page1 {
    private final WebDriver driver;

    public String openGooglePage() {
        driver.navigate().to("http://google.com");
        driver.findElement(By.id("L2AGLb")).click();
        return driver.getTitle();
    }

}
