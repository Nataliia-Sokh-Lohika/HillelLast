package project.tests;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.util.DataProviders;
import project.util.DataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RestWPTestCopy extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class)
    @DataSource(json = "src/test/resources/likes140.json")
    public void testWordPressAPI(String expectedJson) throws JSONException, ParseException, IOException {

        WebResource webResource = client().resource("https://public-api.wordpress.com");

        JSONObject json =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/140/likes")
                        .get(JSONObject.class);
        JSONObject jsonExp = new JSONObject(expectedJson);

        Assert.assertEquals(json,jsonExp);











//TO Read json
    /*    String expectedJson;
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/likes140.json"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            expectedJson  = sb.toString();
        } finally {
            br.close();
        }
*/


    }


















    @Test(enabled = false)
    public void testWordPressAPIPosts() throws JSONException {

        WebResource webResource = client().resource("https://public-api.wordpress.com");
        JSONObject json =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts")
                        .get(JSONObject.class);

        JSONArray array = (JSONArray) json.get("posts");
        JSONObject jsonActual = (JSONObject) array.get(0);
        Assert.assertEquals(jsonActual.get("ID"), 524);

    }





//
//    org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
//
//    Object obj = parser.parse(new FileReader("/Users/nsokh/hillel/TEstAutomationForYandex/src/test/resources/likes140.json"));
//
//    final org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;








//    JSONObject json2 =
//            webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/179/likes")
//                    .get(JSONObject.class);
//    Assert.assertTrue(json2.get("likes").toString().contains("editorwebdrivertest"));


//    /rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts
//JSONArray array = (JSONArray) json.get("posts");





}


