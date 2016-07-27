package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import project.tests.TestNgTestBase;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  public WebDriver driver = TestNgTestBase.driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page() {
    PageFactory.initElements(driver, this);
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
