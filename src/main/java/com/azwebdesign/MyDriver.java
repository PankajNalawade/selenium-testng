package com.azwebdesign;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyDriver {

    WebDriver driver;

    @PostConstruct
    public void setupDriver() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @PreDestroy
    public void takedownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
