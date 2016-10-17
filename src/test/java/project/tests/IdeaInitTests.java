package project.tests;

import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.util.DataProviders;
import project.util.DataSource;


public class IdeaInitTests extends TestNgTestBase {

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, groups = "createIdea",
            dependsOnGroups = "login")
    @DataSource(json = "src/test/resources/testData/ideas/idea.json")
    public void fulfillIdeas(String testData) throws JSONException {
        for (int i = 0; i < 10; i++) {
            JSONObject response = webResource.path("/ideas")
                    .header("X-AUTH-TOKEN", token)
                    .post(JSONObject.class, new JSONObject(testData));

            ideaId = response.get("id").toString();

            if (i % 2 == 0) {
                webResource.path("/ideas/" + ideaId + "/vote")
                        .header("X-AUTH-TOKEN", token)
                        .put(ClientResponse.class, new JSONObject("{\"vote\" : \"true\"}"));
            } else {
                webResource.path("/ideas/" + ideaId + "/vote")
                        .header("X-AUTH-TOKEN", token)
                        .put(ClientResponse.class, new JSONObject("{\"vote\" : \"false\"}"));
            }
            webResource.path("/ideas/" + ideaId + "/status")
                    .header("X-AUTH-TOKEN", token)
                    .put(new JSONObject("{\"status\" : \"UNDER_CONSIDERATION\"}"));


            webResource.path("/ideas/" + ideaId + "/department")
                    .header("X-AUTH-TOKEN", token)
                    .put(ClientResponse.class, new JSONObject("{\"department\" : \"ADMINISTRATIVE\"}"));


            webResource.path("/ideas/" + ideaId + "/comment")
                    .header("X-AUTH-TOKEN", token)
                    .post(ClientResponse.class, new JSONObject("{\"comment\" : \"Hello! I am an automation comment. You should not see me\"}"));


            webResource.path("/ideas/" + ideaId + "/progress")
                    .header("X-AUTH-TOKEN", token)
                    .post(ClientResponse.class, new JSONObject("{\"comment\" : \"Hello! I am an automation progress comment. You should not see me\"}"));
    }

    }
}
