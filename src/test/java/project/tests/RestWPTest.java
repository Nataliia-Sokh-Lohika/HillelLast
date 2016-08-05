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

import java.io.*;

public class RestWPTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }



    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class)
    @DataSource(json = "src/test/resources/likes140.json")
    public void testWordPressAPI(String testData, String verificationData) throws JSONException, ParseException, IOException {



        Assert.assertEquals(testData,verificationData);

      /*  WebResource webResource = client().resource("https://public-api.wordpress.com");

        JSONObject json =
                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/140/likes")
                        .get(JSONObject.class);
*/

//TO Read json
     /*   String expectedJson;
        BufferedReader br = new BufferedReader(new FileReader("/Users/nsokh/hillel/TEstAutomationForYandex/src/test/resources/likes140.json"));
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
        JSONObject jsonExp = new JSONObject(expectedJson);
*/
//        JSONObject jsonExp = new JSONObject(testData);



//        Assert.assertEquals(json.getJSONArray("likes").getJSONObject(0).getJSONArray("").,jsonExp.getJSONArray("likes"),"Good message to understand");



// To write a file
/*
        FileWriter file = new FileWriter("/Users/nsokh/hillel/TEstAutomationForYandex/src/test/resources/likes140.json") ;
            file.write(json.toString());
        file.flush();
        file.close();

            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + json);
*/








//        Неудачная попытка что-то сделать((((
//        Assert.assertEquals(json.get("found"), 1);

//        JSONObject json2 =
//                webResource.path("/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/140/likes")
//                        .get(JSONObject.class);
//
//        Assert.assertEquals(json2.get("found"), 0);

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


