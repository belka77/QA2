package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MobileHomePage {
    BaseFunc baseFunc;
    private static final By ARTICLE_TITLE_MOBILE = By.xpath("//a[@class='md-scrollpos']");


    public MobileHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getAllTitles() {
        List<WebElement> mobileArticleTitles = baseFunc.getElements(ARTICLE_TITLE_MOBILE);
        return mobileArticleTitles;
    }

    public ArticleMobilePage goToFirstMobileArticle() {
        Assert.assertTrue("There is no article", !getAllTitles().isEmpty());
        WebElement firstArticle = getAllTitles().get(0);
        firstArticle.click();
        return new ArticleMobilePage(baseFunc);
    }
}



