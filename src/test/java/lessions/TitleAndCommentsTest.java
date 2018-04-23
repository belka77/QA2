package lessions;

import model.Article;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;
import pages.HomePage;
import pages.MobileHomePage;

import java.util.ArrayList;
import java.util.List;

public class TitleAndCommentsTest {
    private BaseFunc baseFuncWeb = new BaseFunc();
    private BaseFunc baseFuncMobile = new BaseFunc();

    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";

     @Test
    public void firstFiveArticlesTest() {
        // Открываем http://www.delfi.lv/
        baseFuncWeb.goToUrl(MAIN_PAGE_WEB_URL);
        HomePage homePage = new HomePage(baseFuncWeb);

        // Открываем http://m.delfi.lv/
         baseFuncMobile.goToUrl(MAIN_PAGE_MOBILE_URL);
         MobileHomePage mobileHomePage = new MobileHomePage(baseFuncMobile);

        // Находим первые 5 статей на http://www.delfi.lv/
         List<Article> firstFive = homePage.getFirstFive();

        // Находим первые 5 статей на http://m.delfi.lv/
         List<Article> firstFiveMobile = mobileHomePage.getFirstFive();


        // Сравниваем название 1-5 статьи на http://www.delfi.lv/ и http://m.delfi.lv/


        // Сравниваем колличество комментариев 1-5 статьи на http://www.delfi.lv/ и http://m.delfi.lv/


        // Заходим в каждую статью на http://www.delfi.lv/ (с 1-ой по 5-ую)


        // Заходим в каждую статью на http://m.delfi.lv/ (с 1-ой по 5-ую)


        // Сравниваем название 1-5 статьи на http://www.delfi.lv/ и http://m.delfi.lv/


        // Сравниваем колличество комментариев первых 5 статей на http://www.delfi.lv/ и http://m.delfi.lv/
    }
}
