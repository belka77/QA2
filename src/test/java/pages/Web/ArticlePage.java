package pages.Web;

import model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;

import java.util.ArrayList;
import java.util.List;

public class ArticlePage {

    private static BaseFunc baseFunc;
    private BaseFunc baseFunc;

    private static final By ARTICLE_WEB_NAME = By.cssSelector("h1 [itemprop=\"headline name\"]");
    private static final By COMMENT_WEB_COUNT = By.cssSelector("[class=\"article-title\"] [class=\"comment-count\"]");
    private static final By ARTICLE_TITLE = By.cssSelector("[class=\"md-scrollpos\"]");
    private static final By COMMENT = By.cssSelector("[class=\"commentCount\"]");

    public ArticlePage(BaseFunc baseFunc) {
        ArticlePage.baseFunc = baseFunc;
    }

    public static List<Article> firstFiveElement(List<WebElement> articles, By ARTICLE_TITLE, By COMMENT) {

        List<Article> firstFive = new ArrayList<Article>();

        for (int i = 0; i < 5; i++) {

            Article a = new Article();
            WebElement we = articles.get(i);
            a.setTitle(we.findElement(ARTICLE_TITLE).getText());

            if (we.findElements(COMMENT).isEmpty()) {

                a.setCommentCount(0);
            } else {

                a.setCommentCount(we.findElement(COMMENT).getText());
            }
            a.setLink(we.findElement(ARTICLE_TITLE).getAttribute("href"));

            firstFive.add(a);
        }

        public List<Article> firstFiveElements (List < WebElement > articles) {
            return firstFiveElements(articles, ARTICLE_TITLE, COMMENT);
        }

        public String Title (BaseFunc baseFunc){
            return baseFunc.getArticle(ARTICLE_WEB_NAME).getText();
        }

        public int Comment (BaseFunc baseFunc){
            return baseFunc.getCommentsCount(COMMENT_WEB_COUNT);
        }
    }
}
