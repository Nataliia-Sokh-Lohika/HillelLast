package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by nsokh on 7/23/16.
 */
public class SitePage extends Page {

    @FindBy(how = How.CSS, using = "article h2 a")
    @CacheLookup
    private List<WebElement> listOfArticles;
}
