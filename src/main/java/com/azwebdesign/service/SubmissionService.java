package com.azwebdesign.service;

import com.azwebdesign.MyDriver;
import com.azwebdesign.page.PostPage;
import com.azwebdesign.page.SubmitPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

@Component
public class SubmissionService {

    private WebDriver driver;

    @Autowired
    public void setDriver(MyDriver myDriver) {
        this.driver = myDriver.getDriver();
    }

    public void postLink(String link, String subredditName, String title) throws URISyntaxException {
        SubmitPage submitPage = new SubmitPage(driver);
        URI uri = new URI(link);

        submitPage.getUrlInput().sendKeys(link);
        submitPage.getSubreddit().sendKeys(subredditName);
        submitPage.getTitle().sendKeys(title);
        submitPage.getSubmit().click();

        // wait for page to load
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public void postLink(String link, String subredditName) throws URISyntaxException {
        SubmitPage submitPage = new SubmitPage(driver);
        URI uri = new URI(link);

        submitPage.getUrlInput().sendKeys(link);
        submitPage.getSubreddit().sendKeys(subredditName);

        // wait for reddit to suggest title
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(submitPage.getSuggestedTitle()));
        submitPage.useSuggestedTitle();

        submitPage.getSubmit().click();

        // wait for page to load
        wait.until(ExpectedConditions.visibilityOf(new PostPage(driver).getParentComments().get(0)));
    }
}
