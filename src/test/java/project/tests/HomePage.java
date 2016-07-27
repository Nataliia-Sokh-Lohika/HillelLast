package project.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by nsokh on 7/5/16.
 */
public class HomePage extends TestNgTestBase {

    @BeforeMethod
    public void initPageObjects() {
        driver.get(baseUrl);
    }

    @Test(description = "Check number of application in a HomePage Bar", groups = "smoke")
    public void checkPanelAppsNumber() {
        int numberOfApps = pages.getHomePage().getApplicationPanelElements().size();
        Assert.assertTrue(numberOfApps == 7);
    }

    @Test(description = "Check application names in a HomePage Bar", groups = "smoke")
    public void checkPanelAppsNames() {
        String[] expectedApps ={"Images", "Video", "Mail", "Maps", "AppMetrica", "Translate", "Browser"} ;
        for(int i = 0; i < 7; i++){
            String actulresult = pages.getHomePage().getApplicationPanelElements().get(i).getText();
            Assert.assertEquals(actulresult,expectedApps[i], "Assert Apps names matches");
        }
    }

    @Test(description = "Check application URLs in a HomePage Bar", groups = "smoke")
    public void checkPanelAppsURLs() {
        String[] expectedApps ={"https://www.yandex.com/images/", "https://www.yandex.com/video/", "https://mail.yandex.com/", "https://yandex.com/maps/", "https://appmetrica.yandex.com/", "https://translate.yandex.com/", "https://browser.yandex.com/"} ;
        for(int i = 0; i < 7; i++){
            Assert.assertEquals(pages.getHomePage().getApplicationPanelURLs().get(i).getAttribute("href"),expectedApps[i], "Assert Apps URLs matches");
        }
    }


    @Test(description = "Check number of languages in a local panel", groups = "smoke")
    public void checkLocalePanelNumber() {
        int numberOfApps = pages.getHomePage().getLocalesPanelElements().size();
        Assert.assertTrue(numberOfApps == 5);
    }

    @Test(description = "Check locales panel languages", groups = "smoke")
    public void checkLocalesPanelText() {
        String[] expectedApps ={"Russia", "Ukraine", "Belarus", "Kazakhstan", "Turkey"} ;
        for(int i = 0; i < 5; i++){
            Assert.assertEquals(pages.getHomePage().getLocalesPanelElements().get(i).getText(),expectedApps[i], "Assert Locale names matches");
        }
    }

    @Test(description = "Check URLs in a Locale Panel", groups = "smoke")
    public void checkLocalePanelURLs() {
        String[] expectedApps ={"https://www.yandex.ru/", "https://www.yandex.ua/", "https://www.yandex.by/", "https://www.yandex.kz/", "https://www.yandex.com.tr/"} ;
        for(int i = 0; i < 5; i++){
            Assert.assertEquals(pages.getHomePage().getLocalesPanelElements().get(i).getAttribute("href"),expectedApps[i], "Assert Locale URLs matches");
        }
    }

    @Test(description = "Check number of info tabs", groups = "smoke")
    public void checkInfoTabsNumber() {
        int numberOfApps = pages.getHomePage().getInfoPanelElements().size();
        Assert.assertTrue(numberOfApps == 6);
    }

    @Test(description = "Check info panel names", groups = "smoke")
    public void checkInfoPanelText() {
        String[] expectedApps ={"Technologies", "About Yandex", "Terms of Service", "Privacy Policy", "Contact us", "Copyright Notice"} ;
        for(int i = 0; i < 6; i++){
            Assert.assertEquals(pages.getHomePage().getInfoPanelElements().get(i).getText(),expectedApps[i], "Assert Info names matches");
        }
    }

    @Test(description = "Check info panel URLs", groups = "smoke")
    public void checkInfoPanelURLs() {
        String[] expectedApps ={"https://tech.yandex.com/", "https://yandex.com/company/", "https://yandex.com/legal/termsofservice/", "https://yandex.com/legal/privacy/", "https://feedback2.yandex.com/default/", "https://feedback2.yandex.com/copyright-complaint/"} ;
        for(int i = 0; i < 6; i++){
            Assert.assertEquals(pages.getHomePage().getInfoPanelElements().get(i).getAttribute("href"),expectedApps[i], "Assert Info URLs matches");
        }
    }

    @Test(description = "Check Search input fiels ia Displayed and Enabled", groups = "smoke")
    public void checkSearchInput() {
        Assert.assertTrue(pages.getHomePage().getSearchInput().isDisplayed(),"Verify the Searsh input is Displayed");
        Assert.assertTrue(pages.getHomePage().getSearchInput().isEnabled(),"Verify the Searsh input is Enabled");
    }

}
