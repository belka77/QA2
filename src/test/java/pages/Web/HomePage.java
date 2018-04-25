package pages.Web;

import model.Article;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;

import java.util.List;

public class HomePage {

    BaseFunc baseFunc; 
    
    private static final By ARTICLE_TITLE = By.cssSelector("[class=\"top2012-title\"]");
    

    public HomePage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }
    public List<WebElement> getAllTitles() {
        return baseFunc.getElements(ARTICLE_TITLE);
    }
    public ArticlePage goToFirstArticle(){
        Assert.assertTrue("There is no article", !getAllTitles().isEmpty());
        WebElement firstArticle = getAllTitles().get(0);
        firstArticle.click();
        return new ArticlePage(baseFunc);
    }

    public List<WebElement> getAllArticles() {
    }

    public List<Article> firstFiveElements(List<WebElement> articles) {
    }
}