package com.azwebdesign.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    protected WebDriver driver;
    protected String url;

    private PageObject() {};

    public PageObject(WebDriver driver, String url){
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return url;
    }
}
