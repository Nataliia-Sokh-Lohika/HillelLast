package project.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestNgTestBase {



  @BeforeMethod
  public void navigateToUrl() {
    driver.get(mailYandex);
  }

  @Test(description = "Check Login Page Title", groups = "smoke")
  public void checkLoginPageTitle() {
    Assert.assertTrue("Yandex.Mail — a free email service".equals(pages.getLoginPage().getTitle()));
  }

  @Test(description = "Login wrong user", groups = {"func", "negative"})
  public void checkwrongUserLogin() {
    pages.getLoginPage().getUserName().clear();
    pages.getLoginPage().getUserName().sendKeys("testName");
    pages.getLoginPage().getUserPassword().sendKeys("testPassword");
    pages.getLoginPage().getLoginButton().click();
    wait.until(ExpectedConditions.visibilityOf(pages.getPassportPage().getMessageBox()));
    String err =  pages.getPassportPage().getMessageBox().getText();
    Assert.assertEquals(err, "Wrong username or password.\n" +
            "It’s possible that you’re using the wrong keyboard input language or “Caps Lock” is on.");
  }
}
