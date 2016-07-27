package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/6/16.
 */
public class PassportPage extends Page {

    @FindBy(how = How.CSS, using = ".js-messages")
    @CacheLookup
    private WebElement messageBox;

    public WebElement getMessageBox() {
        return messageBox;
    }
}
