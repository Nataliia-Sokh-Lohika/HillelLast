package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by nsokh on 7/4/16.
 */

public class HomePage extends Page {

    @FindBy(how = How.CSS, using = ".tabs .tabs__item__text")
    @CacheLookup
    private List<WebElement> applicationPanelElements;

    @FindBy(how = How.CSS, using = ".tabs a")
    @CacheLookup
    private List<WebElement> applicationPanelURLs;

    @FindBy(how = How.CSS, using = ".worldwide__list a")
    @CacheLookup
    private List<WebElement> localesPanel;

    @FindBy(how = How.CSS, using = " .b-line__mfooter a")
    @CacheLookup
    private List<WebElement> infoPanel;

    @FindBy(how = How.CSS, using = ".input__input")
    @CacheLookup
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = ".search2__button button")
    @CacheLookup
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = ".keyboard-loader.input__keyboard-button")
    @CacheLookup
    private WebElement keyBoardLoader;

    @FindBy(how = How.CSS, using = " a .b-inline")
    @CacheLookup
    private WebElement logInLink;


    public List<WebElement> getApplicationPanelElements() {
        return applicationPanelElements;
    }

    public List<WebElement> getApplicationPanelURLs() {
        return applicationPanelURLs;
    }

    public List<WebElement> getLocalesPanelElements() {
        return localesPanel;
    }

    public List<WebElement> getInfoPanelElements() {
        return infoPanel;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getKeyBoardLoader() {
        return keyBoardLoader;
    }

    public WebElement getLogInLink() {
        return logInLink;
    }
}