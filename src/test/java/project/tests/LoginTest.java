package project.tests;

import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jettison.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.util.DataProviders;
import project.util.DataSource;


public class LoginTest extends TestNgTestBase {

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, groups = "login")
    @DataSource(json = "src/test/resources/testData/user/testUserLogin.json")
    public void login(String testData) throws JSONException {

        ClientResponse js = webResource.path("/login").post(ClientResponse.class, testData);

        token = js.getHeaders().get("X-Auth-Token").get(0);

        Assert.assertTrue(js.getClientResponseStatus().getStatusCode() == 200, "Assert that login method status code is 200");
    }
}
