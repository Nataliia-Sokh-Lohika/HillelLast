package project.pages.work;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import project.pages.Page;

/**
 * Created by nsokh on 7/23/16.
 */
public class ArticlePage extends Page {

    @FindBy(how = How.CSS, using = ".like.sd-button")
    private WebElement likeButton;

    public WebElement getLikeButton() {
        return likeButton;
    }

}
