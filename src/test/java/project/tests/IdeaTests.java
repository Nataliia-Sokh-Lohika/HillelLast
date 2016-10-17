package project.tests;

import com.sun.jersey.api.client.ClientResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.util.DataProviders;
import project.util.DataSource;


public class IdeaTests extends TestNgTestBase {

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, groups = "createIdea",
    dependsOnGroups = "login")
    @DataSource(json = "src/test/resources/testData/ideas/idea.json")
    public void createIdea(String testData) throws JSONException {

        JSONObject response = webResource.path("/ideas")
                .header("X-AUTH-TOKEN", token)
                .post(JSONObject.class, new JSONObject(testData));

        ideaId = response.get("id").toString();

        Assert.assertNotNull(ideaId, "Assert that ideaId is not null");
    }

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class,dependsOnGroups = "createIdea")
    @DataSource(json = "src/test/resources/testData/ideas/voting.json")
    public void votingIdea(String testData) throws JSONException {

        webResource.path("/ideas/" + ideaId + "/vote")
                .header("X-AUTH-TOKEN", token)
                .put(ClientResponse.class, new JSONObject(testData));

        JSONObject jsonObject = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .get(JSONObject.class);
        if (testData.contains("false")) {
            Assert.assertTrue(jsonObject.getJSONArray("likes").isNull(0));
            Assert.assertEquals(jsonObject.getJSONArray("dislikes").get(0), "ideabox-ldap");
        } else {
            Assert.assertTrue(jsonObject.get("dislikes").equals(null));
            Assert.assertEquals(jsonObject.getJSONArray("likes").get(0), "ideabox-ldap");
        }

    }


    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class,dependsOnGroups = "createIdea")
    @DataSource(json = "src/test/resources/testData/ideas/statuses.json")
    public void moveThroughStatuses(String testData) throws JSONException {

        webResource.path("/ideas/" + ideaId + "/status")
                .header("X-AUTH-TOKEN", token)
                .put(new JSONObject(testData));

        JSONObject jsonObject = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .get(JSONObject.class);

        Assert.assertEquals(jsonObject.get("status"), new JSONObject(testData).get("status"));

    }


    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, dependsOnGroups = "createIdea")
    @DataSource(json = "src/test/resources/testData/ideas/departments.json")
    public void moveThroughDepartments(String testData) throws JSONException {

        ClientResponse response = webResource.path("/ideas/" + ideaId + "/department")
                .header("X-AUTH-TOKEN", token)
                .put(ClientResponse.class, new JSONObject(testData));

        JSONObject jsonObject = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .get(JSONObject.class);

        Assert.assertEquals(jsonObject.get("department"), new JSONObject(testData).get("department"));

    }


    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, dependsOnGroups = "createIdea")
    @DataSource(json = "src/test/resources/testData/ideas/comments.json")
    public void addComments(String testData) throws JSONException {

        ClientResponse response = webResource.path("/ideas/" + ideaId + "/comment")
                .header("X-AUTH-TOKEN", token)
                .post(ClientResponse.class, new JSONObject(testData));

        JSONObject jsonObject = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .get(JSONObject.class);

        Assert.assertEquals(jsonObject.getJSONArray("comments").getJSONObject(0).get("comment"), new JSONObject(testData).get("comment"));
        Assert.assertEquals(jsonObject.getJSONArray("comments").getJSONObject(0).get("authorId"), "ideabox-ldap");

    }


    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class, dependsOnGroups = "createIdea")
    @DataSource(json = "src/test/resources/testData/ideas/progress.json")
    public void addProgressComment(String testData) throws JSONException {

        ClientResponse response = webResource.path("/ideas/" + ideaId + "/progress")
                .header("X-AUTH-TOKEN", token)
                .post(ClientResponse.class, new JSONObject(testData));

        JSONObject jsonObject = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .get(JSONObject.class);

        Assert.assertEquals(jsonObject.getJSONArray("progressComments").getJSONObject(0).get("comment"), new JSONObject(testData).get("comment"));
        Assert.assertEquals(jsonObject.getJSONArray("progressComments").getJSONObject(0).get("authorId"), "ideabox-ldap");

    }

    @Test( priority = 3, dependsOnGroups = "createIdea")
    public void deleteIdea() throws JSONException {

        ClientResponse response = webResource.path("/ideas/" + ideaId)
                .header("X-AUTH-TOKEN", token)
                .delete(ClientResponse.class);

        JSONArray response2 = webResource.path("/ideas/")
                .header("X-AUTH-TOKEN", token)
                .get(JSONArray.class);
          Assert.assertTrue(!response2.toString().contains(ideaId));
    }


}
