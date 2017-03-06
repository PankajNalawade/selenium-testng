package com.azwebdesign.service;

import com.azwebdesign.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrowserService {

    private WebDriver driver;

    @Autowired
    public void setDriver(MyDriver myDriver) {
        this.driver = myDriver.getDriver();
    }

    public void goTo(String address) {
        driver.get(address);

        // wait for page to load
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("body"))));
    }

    public boolean titleContains(String titleContains) {
        String title = driver.getTitle();
        return title.contains(titleContains);
    }
}
