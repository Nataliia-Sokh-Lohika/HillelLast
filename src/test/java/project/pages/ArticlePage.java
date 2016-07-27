package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nsokh on 7/23/16.
 */
public class ArticlePage extends Page {

    @FindBy(how = How.CSS, using = ".liked.sd-button")
    private WebElement likeButton;

    public WebElement getLikeButton() {
        return likeButton;
    }
}
