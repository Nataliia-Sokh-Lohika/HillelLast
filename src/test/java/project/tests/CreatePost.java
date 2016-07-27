package project.tests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by nsokh on 7/26/16.
 */
public class CreatePost extends TestNgTestBase {
    @BeforeMethod
    public void navigateToURL(){
        driver.get("https://wordpress.com/wp-login.php");
    }

    @Test()
    public void  createPostTest() throws JSONException {
//        pages.getLoginWPPage().getUserName().sendKeys("nataliiasokh");
//        pages.getLoginWPPage().getUserPassword().sendKeys("P@ssw0rd");
//        pages.getLoginWPPage().getSubmitButton().click();
//        wait.until(ExpectedConditions.elementToBeClickable(pages.getAdminWPPage().getCreateNewButton()));
//        pages.getAdminWPPage().getCreateNewButton().click();
//        wait.until(ExpectedConditions.visibilityOf(pages.getEditorPage().getPostTitle()));
//        pages.getEditorPage().getPostTitle().sendKeys("Hillel test auto");
//        pages.getEditorPage().getPostDescription().sendKeys("Hillel test description");
//        pages.getEditorPage().getPublishButton().click();



      JSONObject json = webResource.path("/rest/v1.1/sites/nataliiasokh.wordpress.com/posts").get(JSONObject.class);
        JSONArray jsonArray =  json.getJSONArray("posts");
        boolean postCreated = false;
        for (int i = 0; i < jsonArray.length(); i++){
            if(jsonArray.getJSONObject(i).getString("title").equals("Hillel test auto")){
                postCreated = true;
                break;
            }
        }
        Assert.assertTrue(postCreated);
    }

}
