package project.tests;

import org.testng.Assert;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class RestTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    @Test()
    public void testUserFetchesSuccess() throws JSONException {

        WebResource webResource = client().resource("http://services.groupkt.com");
        JSONObject json =
                webResource.path("/state/get/IND/all")
                        .get(JSONObject.class);
        Assert.assertEquals("Abracodabra", json.get("RestResponse"));
    }

    @Test()
    public void testPostsAPI() throws JSONException {

        WebResource webResource = client().resource("http://jsonplaceholder.typicode.com");
        JSONObject json =
                webResource.path("/posts/1")
                        .get(JSONObject.class);
        Assert.assertEquals(2643743, json.get("id"));
    }


    @Test()
    public void testWeatherAPI() throws JSONException {

        WebResource webResource = client().resource("http://api.openweathermap.org");
        JSONObject json =
                webResource.path("/data/2.5/weather").queryParam("q","London")
                        .queryParam("APPID","e3d7b9e76ebe246d71e2a561c9bb8368")
                        .get(JSONObject.class);
        Assert.assertEquals(2643743, json.get("id"));
    }



    @Test()
    public void testWordPressAPI() throws JSONException {

        WebResource webResource = client().resource("http://api.openweathermap.org");
        JSONObject json =
                webResource.path("/data/2.5/weather").queryParam("q","London")
                        .queryParam("APPID","e3d7b9e76ebe246d71e2a561c9bb8368")
                        .get(JSONObject.class);
        Assert.assertEquals(2643743, json.get("id"));

    }

}


