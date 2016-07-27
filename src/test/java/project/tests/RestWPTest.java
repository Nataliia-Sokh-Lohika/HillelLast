package project.tests;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RestWPTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    @Test(enabled = false)
    public void testWordPressAPI() throws JSONException {

        WebResource webResource = client().resource("https://public-api.wordpress.com");
        JSONObject json =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/140/likes")
                        .get(JSONObject.class);

        Assert.assertEquals(json.get("found"), 0);

        JSONObject json2 =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/140/likes")
                        .get(JSONObject.class);

        Assert.assertEquals(json2.get("found"), 1);

    }

    @Test()
    public void testWordPressAPIPosts() throws JSONException {

        WebResource webResource = client().resource("https://public-api.wordpress.com");
        JSONObject json =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts")
                        .get(JSONObject.class);

        JSONArray array = (JSONArray) json.get("posts");
        JSONObject jsonActual = (JSONObject) array.get(0);
        Assert.assertEquals(jsonActual.get("ID"), 180);

    }








//    JSONObject json2 =
//            webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/179/likes")
//                    .get(JSONObject.class);
//    Assert.assertTrue(json2.get("likes").toString().contains("editorwebdrivertest"));


//    /rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts
//JSONArray array = (JSONArray) json.get("posts");


}


