package project.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.ITestContext;
import org.testng.annotations.*;

import project.util.PropertyLoader;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase extends JerseyTest {

  public static String ideaId;
  public static String token;

  public TestNgTestBase(){
    try {
      baseUrl = PropertyLoader.loadProperty("site.url");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  @Override
  protected AppDescriptor configure() {
    return new WebAppDescriptor.Builder().build();
  }

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  public static WebDriver driver;
  public static WebResource webResource;






  @BeforeSuite
  public void initTestSuite(ITestContext testContext) throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    webResource = client().resource(baseUrl);


  }

  @BeforeMethod
  public void initWebDriver(Method m) {
//    MarionetteDriverManager.getInstance().setup();
//   driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
//    wait = new WebDriverWait(driver,10);

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(ITestContext testContext) {
//    WebDriverFactory.dismissAll();

  }

  //TEST LEVEL
  @BeforeTest(enabled = true, alwaysRun = true)
  public void beforeTest(ITestContext testContext){
  }

  @AfterTest(enabled = true, alwaysRun = true)
  public void afterTest(ITestContext testContext){
  }

  //GROUPS LEVEL
  @BeforeGroups(enabled = true, alwaysRun = true)
  public void beforeGroups(ITestContext testContext){
    //
  }

  @AfterGroups(enabled = true, alwaysRun = true)
  public void afterGroups(ITestContext testContext){
    //
  }

  //CLASS LEVEL
  @BeforeClass(enabled = true, alwaysRun = true)
  public void beforeClass(ITestContext testContext){
    //
  }

  @AfterClass(enabled = true, alwaysRun = true)
  public void afterClass(ITestContext testContext){
    //
  }

  @AfterMethod(enabled = true, alwaysRun = true)
  public void afterMethod(Method m) throws URISyntaxException {
  }


}
