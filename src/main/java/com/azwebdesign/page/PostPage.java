package com.azwebdesign.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PostPage extends PageObject {

    public PostPage(WebDriver driver) {
        this(driver, null);
    }

    public PostPage(WebDriver driver, String url) {
        super(driver, url);
    }

    @FindBy(css = "a.title")
    WebElement title;

    @FindBy(css = "div.likes")
    WebElement likes;

    @FindBy(css = "div.sitetable .thing")
    List<WebElement> parentComments;

    public WebElement getTitle() {
        return title;
    }

    public WebElement getLikes() {
        return likes;
    }

    public List<WebElement> getParentComments() {
        return parentComments;
    }
}
