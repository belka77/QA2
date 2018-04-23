package pages;

import model.Article;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private static final By TITLE = By.xpath(".//a[contains(@class, 'top2012-title')]");
    private static final By COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> getAllTitles() {
        return baseFunc.getElements(TITLE);
    }

    public List<Article> getFirstFive() {
        List<WebElement> articleTitles = getAllTitles();
        List<Article> firstFive = new ArrayList<Article>();

        for (int i = 0; i < 5; i++) {
            Article a = new Article();
            WebElement we = articleTitles.get(i);

            a.setTitle(we.findElement(TITLE).getText());

            if (we.findElements(COMMENTS).isEmpty()) {
                a.setCommentCount(0);
            } else {
                a.setCommentCount(we.findElement(COMMENTS).getText());
            }

            a.setLink(we.findElement(TITLE).getAttribute("href"));

            firstFive.add(a);
        }

        return firstFive;

    }


    public ArticlePage goToFirstArticle() {
        Assert.assertTrue("There is no article", !getAllTitles().isEmpty());
        WebElement firstArticle = getAllTitles().get(0);
        firstArticle.click();
        return new ArticlePage(baseFunc);
    }
}

