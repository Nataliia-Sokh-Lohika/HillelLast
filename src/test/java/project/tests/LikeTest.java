package project.tests;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by nsokh on 7/23/16.
 */
public class LikeTest extends TestNgTestBase{

    @BeforeMethod
    public void navigateToURL (){
        driver.get("https://sergeywebdrivertest.wordpress.com");
        driver.manage().window().maximize();
    }

    @Test(description = "Verify Like is working", enabled = true)
    public void checkLike() throws InterruptedException, JSONException {

        JSONObject json =
        webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/180/likes")
                .get(JSONObject.class);

        Assert.assertEquals(json.get("found"), 0);


        pages.getSitePage().getArticles().get(0).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".post-likes-widget.jetpack-likes-widget")));

        driver.switchTo().frame(driver.findElement(By.cssSelector(".post-likes-widget.jetpack-likes-widget")));
        pages.getArticlePage().getLikeButton().click();
        Thread.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.findElement(By.id("user_login")).sendKeys("editorwebdrivertest");
        driver.findElement(By.id("user_pass")).sendKeys("EditorTest");
        driver.findElement(By.name("wp-submit")).click();

                JSONObject json2 =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/180/likes")
                        .get(JSONObject.class);

        Assert.assertEquals(json2.get("found"), 1);





    }
}
