package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;
    private static final By ARTICLE_TITLE = By.xpath("//a[@class='top2012-title']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getAllTitles() {
        List<WebElement> articleTitles = baseFunc.getElements(ARTICLE_TITLE);
        return articleTitles;
    }

    public ArticlePage goToFirstArticle() {
        Assert.assertTrue("There is no article", !getAllTitles().isEmpty());
        WebElement firstArticle = getAllTitles().get(0);
        firstArticle.click();
        return new ArticlePage(baseFunc);
    }
}

