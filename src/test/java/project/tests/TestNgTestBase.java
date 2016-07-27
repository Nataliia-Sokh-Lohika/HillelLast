package project.tests;

import java.io.IOException;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import project.pages.Pages;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import project.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase extends JerseyTest {

  @Override
  protected AppDescriptor configure() {
    return new WebAppDescriptor.Builder().build();
  }

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static String mailYandex;
  protected static Capabilities capabilities;
  protected static Pages pages;
  public static WebDriver driver;
  WebDriverWait wait;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    mailYandex = PropertyLoader.loadProperty("email.yandex");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
//    MarionetteDriverManager.getInstance().setup();
   driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    wait = new WebDriverWait(driver,10);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }

  public WebResource webResource = client().resource("https://public-api.wordpress.com");
}
