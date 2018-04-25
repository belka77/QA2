package lessions;

import model.Article;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.Mobile.ArticleMobilePage;
import pages.Web.ArticlePage;
import pages.Web.HomePage;
import pages.Mobile.MobileHomePage;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TitleAndCommentsTest {
    private BaseFunc baseFuncWeb = new BaseFunc();
    private BaseFunc baseFuncMobile = new BaseFunc();

    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";

     @Test
    public void firstFiveArticlesTest(BaseFunc baseFunc) {
        // Открываем http://www.delfi.lv/
        baseFuncWeb.goToUrl(MAIN_PAGE_WEB_URL);
        HomePage homePage = new HomePage(baseFuncWeb);

         ArticlePage articlePage = new ArticlePage(baseFunc);

         // создаем список со статьями на веб.версии
         List<WebElement> articles = homePage.getAllArticles() ;

         // проверяем список полный или пустой
         assertTrue("Article list is empty", !articles.isEmpty());

         // создаем список из первых 5 статей на веб.версии
         List<Article> firstFive = homePage.firstFiveElements(articles);


        // Открываем http://m.delfi.lv/
         baseFuncMobile.goToUrl(MAIN_PAGE_MOBILE_URL);
         MobileHomePage mobileHomePage = new MobileHomePage(baseFuncMobile);

         ArticleMobilePage articleMobilePage = new ArticleMobilePage();

        // создаем список со статьями на моб.версии
         List<WebElement> articlesMobile = mobileHomePage.getAllArticles();

         // проверяем список полный или пустой
         assertTrue("Article list is empty", !articlesMobile.isEmpty());

         // создаем список из первых 5 статей на моб.версии
         List<Article> firstFiveMobile = mobileHomePage.firstFiveElements(articlesMobile);

         for (int i = 0; i < 5; i++) {

             String WebTitle = firstFive.get(i).getTitle();
             String MobTitle = firstFiveMobile.get(i).getTitle();

             Assert.assertEquals("Titles on the Web and on the Mob are different", WebTitle, MobTitle);

             int WebComment = firstFive.get(i).getCommentCount() ;
             int MobComment = firstFiveMobile.get(i).getCommentCount() ;

             Assert.assertEquals("Comments count on the Web and on the Mob are different", WebComment, MobComment);


             mobileHomePage.clickOnElement();


             String WebTitleArticle = articlePage.Title(baseFuncWeb);

             Assert.assertEquals("Web article title at Article page is not the same as on Home page", WebTitle, WebTitleArticle);

             int commentCountTextWeb =  articlePage.Comment(baseFuncWeb);

             Assert.assertEquals("Comments count is different", WebComment, commentCountTextWeb);

             MobileHomePage.clickOnElement(i, mobileHomePage, firstFiveMobile);

             String MobTitleArticle = articleMobilePage.Title(baseFuncMobile);

             Assert.assertEquals("Mobile version Article name at article page is not the same as on main page", MobTitle, MobTitleArticle);
             Assert.assertEquals("Article title at article Mob page is not the same as on Home page Mob version", MobTitleArticle, WebTitleArticle);

             int commentCountTextMob =  articleMobilePage.Comment(baseFuncMobile);

             Assert.assertEquals("Comments amount is different", MobComment, commentCountTextMob);
             Assert.assertEquals("Comments amount is different", commentCountTextWeb, commentCountTextMob);



         }

     }

}

