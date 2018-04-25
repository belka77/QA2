package pages.Mobile;

import model.Article;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;

import java.util.ArrayList;
import java.util.List;

public class MobileHomePage {
    BaseFunc baseFunc;

    private static final By ARTICLE =  By.cssSelector("[class=\"md-mosaic-title\"]");
    private static final By ARTICLE_TITLE = By.cssSelector("[class=\"md-scrollpos\"]");
    private static final By COMMENT =  By.cssSelector("[class=\"commentCount\"]");

    public MobileHomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }
    public List<WebElement> getAllTitles() {
        return baseFunc.getElements(ARTICLE_TITLE);
    }
    public List<WebElement> getAllArticles() {
        return baseFunc.getArticles(ARTICLE);
    }
    public List<Article> firstFiveElements(List<WebElement> articles) {
        return firstFiveElements(articles, ARTICLE_TITLE, COMMENT);
    }

    public MobileHomePage clickOnElement(int i, MobileHomePage, List<Article> firstFive ){
        baseFunc.goToUrl(firstFive.get(i).getLink());
        return page;

    }



}

