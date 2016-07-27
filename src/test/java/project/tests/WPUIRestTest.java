package project.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by nsokh on 7/23/16.
 */
public class WPUIRestTest extends TestNgTestBase {
    @BeforeMethod
    public void navigateToUrl() {
        driver.get("https://sergeywebdrivertest.wordpress.com/");
        driver.manage().window().maximize();
    }

    @Test()
    public void checkLike() throws InterruptedException {

       pages.getSitePage().getArticles().get(0).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".post-likes-widget.jetpack-likes-widget")));
        pages.getArticlePage().getLikeButton().click();
        Thread.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.switchTo().window(driver.getWindowHandles().iterator().next());

//        Assert.assertTrue("Yandex.Mail — a free email service".equals(pages.getLoginPage().getTitle()));
    }
}
