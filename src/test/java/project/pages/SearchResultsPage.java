package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by nsokh on 7/5/16.
 */
public class SearchResultsPage extends Page {

    @FindBy(how = How.CSS, using = ".navigation__region > div")
    @CacheLookup
    private List<WebElement> leftNavigationTabs;

    @FindBy(how = How.CSS, using = " .content__left .serp-item")
    @CacheLookup
    private List<WebElement> searchResultsListed;

    @FindBy(how = How.CSS, using = " .search2__input .input__box")
    @CacheLookup
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = " .input__box .input__settings")
    private WebElement inputSettings;

    @FindBy(how = How.CSS, using = ".main__advanced-search")
    @CacheLookup
    private WebElement advancedSearchBlock;

    public List<WebElement> getLeftNavigationTabs() {
        return leftNavigationTabs;
    }

    public List<WebElement> getSearchResultsListed() {
        return searchResultsListed;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getInputSettings() {
        return inputSettings;
    }

    public WebElement getAdvancedSearchBlock() {
        return advancedSearchBlock;
    }
}
