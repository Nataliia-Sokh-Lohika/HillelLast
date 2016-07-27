package project.pages;

import project.pages.work.SitePage;

/**
 * Created by nsokh on 7/4/16.
 */
public class Pages {

    public static LoginPage getLoginPage(){
        return new LoginPage();
    }

    public static HomePage getHomePage(){
        return new HomePage();
    }

    public static SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage();
    }

    public static PassportPage getPassportPage(){
        return new PassportPage();
    }

    public static SitePage getSitePage(){
        return new SitePage();
    }

    public static project.pages.work.ArticlePage getArticlePage(){
        return new project.pages.work.ArticlePage();
    }

    public static LoginPageWP getLoginWPPage(){
        return new LoginPageWP();
    }

    public static AdminWPPage getAdminWPPage(){
        return new AdminWPPage();
    }


    public static EditorPage getEditorPage(){
        return new EditorPage();
    }


}
