package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/4/16.
 */
public class AdminWPPage extends Page {


    @FindBy(how = How.CSS, using = ".masterbar__item-new")
    @CacheLookup
    private WebElement createNewButton;

    public WebElement getCreateNewButton() {
        return createNewButton;
    }

}


