package com.azwebdesign.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListPage extends PageObject {

    public ListPage(WebDriver driver) {
        this(driver, "http://www.reddit.com");
    }

    public ListPage(WebDriver driver, String url) {
        super(driver, url);
    }

    @FindBy(id = "header")
    WebElement header;

    @FindBy(css = "#header ul.tabmenu li")
    List<WebElement> tabs;

    @FindBy(id = "siteTable")
    WebElement table;

    @FindBy(css = "div#siteTable div.thing")
    List<WebElement> things;

    @FindBy(name = "user")
    WebElement username;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "rem")
    WebElement rememberMe;

    @FindBy(css = "div.submit button")
    WebElement loginSubmit;

    @FindBy(css = "div.submit-link a")
    WebElement submitLink;

    @FindBy(css = "form.logout a")
    WebElement logout;

    public WebElement getHeader() {
        return header;
    }

    public List<WebElement> getTabs() {
        return tabs;
    }

    public WebElement getTable() {
        return table;
    }

    public List<WebElement> getThings() {
        return things;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getRememberMe() {
        return rememberMe;
    }

    public WebElement getLoginSubmit() {
        return loginSubmit;
    }

    public WebElement getSubmitLink() {
        return submitLink;
    }

    public WebElement getLogout() {
        return logout;
    }
}
