package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/4/16.
 */
public class EditorPage extends Page {


    @FindBy(how = How.CSS, using = ".editor-title__input")
    @CacheLookup
    private WebElement title;

    public WebElement getPostTitle() {
        return title;
    }


    @FindBy(how = How.CSS, using = ".tinymce")
    @CacheLookup
    private WebElement description;

    public WebElement getPostDescription() {
        return description;
    }


    @FindBy(how = How.CSS, using = ".editor-ground-control__publish-button.is-primary")
    @CacheLookup
    private WebElement publishButton;

    public WebElement getPublishButton() {
        return publishButton;
    }





}


