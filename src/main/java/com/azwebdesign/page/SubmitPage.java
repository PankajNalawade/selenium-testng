package com.azwebdesign.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmitPage extends PageObject {

    public SubmitPage(WebDriver driver) {
        this(driver, "https://www.reddit.com/submit");
    }

    public SubmitPage(WebDriver driver, String url) {
        super(driver, url);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("url")));
    }

    @FindBy(id = "url")
    WebElement url;

    @FindBy(css = "textarea[name='title']")
    WebElement title;

    @FindBy(css = "input[name='sr']")
    WebElement subreddit;

    @FindBy(css = "button[name='submit']")
    WebElement submit;

    @FindBy(css = "div#suggest-title a")
    WebElement useSuggestedTitle;

    public WebElement getUrlInput() {
        return url;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getSubreddit() {
        return subreddit;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getSuggestedTitle() {
        return useSuggestedTitle;
    }

    public void useSuggestedTitle() {
        useSuggestedTitle.click();
    }
}
