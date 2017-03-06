package com.azwebdesign.service;

import com.azwebdesign.MyDriver;
import com.azwebdesign.page.ListPage;
import com.azwebdesign.page.SubmitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListPageService {

    private WebDriver driver;

    @Autowired
    public void setDriver(MyDriver myDriver) {
        this.driver = myDriver.getDriver();
    }

    public List<WebElement> getAllThings() {
        ListPage listPage = new ListPage(driver);
        return listPage.getThings();
    }

    public boolean findItemWithTitle(String titleContains) {
        boolean found = false;

        for(WebElement thing : getAllThings()) {
            WebElement title = thing.findElement(By.className("title"));
            if (title.getText().contains(titleContains)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void clickSubmitLink() {
        ListPage listPage = new ListPage(driver);
        listPage.getSubmitLink().click();

        // wait for page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains(new SubmitPage(driver).getUrl()));
    }
}
