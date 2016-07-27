package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/4/16.
 */
public class LoginPage extends Page {

    @FindBy(how = How.CSS, using = ".js-login input")
    @CacheLookup
    private WebElement userName;

    @FindBy(how = How.CSS, using = ".js-passwd input")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(how = How.CSS, using = ".new-auth-submit button")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = ".new-auth-form-button")
    @CacheLookup
    private WebElement createAccountButton;

    @FindBy(how = How.CSS, using = "._nb-checkbox-input")
    @CacheLookup
    private WebElement dontRememberCheckbox;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserPassword() {
        return userPassword;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public WebElement getDontRememberCheckbox() {
        return dontRememberCheckbox;
    }

}


