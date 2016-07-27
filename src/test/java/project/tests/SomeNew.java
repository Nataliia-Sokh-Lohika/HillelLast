package project.tests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsokh on 7/26/16.
 */
public class SomeNew extends TestNgTestBase{

    @BeforeMethod
    public void navigateToUrl() {
        driver.get("https://nataliiasokh.wordpress.com/");
        driver.manage().window().maximize();
    }

    @Test()
    public void checkLike() throws InterruptedException, JSONException {

        List<String> titles = new ArrayList<String>();
        JSONObject json = webResource.path("/rest/v1.1/sites/nataliiasokh.wordpress.com/posts/")
                .get(JSONObject.class);
          JSONArray posts = json.getJSONArray("posts");
        for(int i = 0; i < posts.length(); i++ ){
            titles.add(posts.getJSONObject(i).getString("title"));
        }
        Assert.assertTrue(titles.contains("Test"));



        pages.getSitePage().getArticles().get(0).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".post-likes-widget.jetpack-likes-widget")));
        pages.getArticlePage().getLikeButton().click();
        Thread.sleep(2000);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
}
}
