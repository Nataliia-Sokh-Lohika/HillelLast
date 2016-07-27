package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/4/16.
 */
public class LoginPageWP extends Page {

    @FindBy(how = How.CSS, using = "#user_login")
    @CacheLookup
    private WebElement userName;

    @FindBy(how = How.CSS, using = "#user_pass")
    @CacheLookup
    private WebElement userPassword;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getUserPassword() {
        return userPassword;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    @FindBy(how = How.CSS, using = "  #wp-submit")
    @CacheLookup
    private WebElement submitButton;


}


