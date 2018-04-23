package pages;

import model.Article;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MobileHomePage {
    BaseFunc baseFunc;
    private static final By ARTICLE_TITLE_MOBILE = By.xpath("//a[@class='md-scrollpos']");
    private static final By COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");


    public MobileHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public List<WebElement> getAllTitles() {
        return baseFunc.getElements(ARTICLE_TITLE_MOBILE);
    }

    public List<Article> getFirstFive() {
        List<WebElement> articleTitles = getAllTitles();
        List<Article> firstFive = new ArrayList<Article>();

        for (int i = 0; i < 5; i++) {
            Article a = new Article();
            WebElement we = articleTitles.get(i);

            a.setTitle(we.findElement(ARTICLE_TITLE_MOBILE).getText());

            if (we.findElements(COMMENTS).isEmpty()) {
                a.setCommentCount(0);
            } else {
                a.setCommentCount(we.findElement(COMMENTS).getText());
            }

            a.setLink(we.findElement(ARTICLE_TITLE_MOBILE).getAttribute("href"));

            firstFive.add(a);
        }

        return firstFive;

    }