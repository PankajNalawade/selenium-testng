package com.azwebdesign;

import com.azwebdesign.page.ListPage;
import com.azwebdesign.page.PostPage;
import com.azwebdesign.service.ListPageService;
import com.azwebdesign.service.LoginService;
import com.azwebdesign.service.SubmissionService;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

@ContextConfiguration(classes = SeleniumApplication.class)
public class RedditSubmissionTests extends AbstractTestNGSpringContextTests {

    private WebDriver driver;

    @Autowired
    private LoginService loginService;
    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private ListPageService listPageService;

    @Autowired
    public void setDriver(MyDriver myDriver) {
        this.driver = myDriver.getDriver();
    }

    @Test(groups = {"smoke-test"}, priority = 10)
    public void testSubmitNewLink() throws URISyntaxException {
        ListPage listPage = new ListPage(driver);
        PostPage postPage = new PostPage(driver);

        loginService.login();
        listPage.getSubmitLink().click();
        submissionService.postLink("http://rickhanton.com/?q=opinion/support-innovation-supporting-failure", "bottesting");
        Assert.assertTrue(postPage.getTitle().getText().contains("failure"));
        Assert.assertTrue(postPage.getLikes().getText().equals(Integer.toString(1)));
    }

    @Test(groups = {"smoke-test"}, priority = 20)
    public void testVerifyNewLink() {
        driver.get("http://www.reddit.com/r/bottesting");
        Assert.assertTrue(listPageService.findItemWithTitle("failure"));
    }
}
