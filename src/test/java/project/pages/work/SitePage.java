package project.pages.work;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import project.pages.Page;

import java.util.List;

/**
 * Created by nsokh on 7/23/16.
 */
public class SitePage  extends Page {
    @FindBy(how = How.CSS, using = "article a")
    @CacheLookup
    private List<WebElement> articles;

    public List<WebElement> getArticles() {
        return articles;
    }

    @FindBy(how = How.CSS, using = ".like.sd-button")
    private WebElement likeButton;

    public WebElement getLikeButton() {
        return likeButton;
    }

}
