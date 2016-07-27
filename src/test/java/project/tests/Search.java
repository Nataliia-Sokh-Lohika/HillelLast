package project.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import project.pages.SearchResultsPage;

/**
 * Created by nsokh on 7/6/16.
 */
public class Search extends TestNgTestBase {

    SearchResultsPage searchResultsPage= pages.getSearchResultsPage();

    @BeforeMethod
    public void initPageObjects() {
        driver.get("https://yandex.ua/search");
    }

    @Test(description = "Verify Search request number of rows", groups = "func")
    public void checkSearchRows() {
        driver.get(baseUrl);
        pages.getHomePage().getSearchInput().sendKeys("Java");
        pages.getHomePage().getSearchButton().click();
        wait.until(ExpectedConditions.visibilityOf(pages.getSearchResultsPage().getInputSettings()));
        int searchResultsDisplayed = pages.getSearchResultsPage().getSearchResultsListed().size();
        Assert.assertEquals(searchResultsDisplayed, 10, "Assert 10 search results are displayed");
    }

    @Test(description = "Verify Search Page left bar", groups = "smoke")
    public void checkLeftBarRowsNumber() {
        int actualTabsNumber = pages.getSearchResultsPage().getLeftNavigationTabs().size();
        Assert.assertEquals(actualTabsNumber, 12, "Assert 12 navigation tabs are displayed");
    }


    @Test(description = "Verify Advanced Search settings", groups = "func")
    public void checkAdvancedSearch() {
        pages.getSearchResultsPage().getInputSettings().click();
        wait.until(ExpectedConditions.visibilityOf(pages.getSearchResultsPage().getAdvancedSearchBlock()));
    }

}
