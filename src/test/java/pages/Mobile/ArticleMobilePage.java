package pages.Mobile;

import model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseFunc;

import java.util.List;

public class ArticleMobilePage {

        private BaseFunc baseFunc;

        private static final By ARTICLE_TITLE = By.cssSelector("[class=\"md-scrollpos\"]");
        private static final By COMMENT = By.cssSelector("[class=\"commentCount\"]");
        private static final By ARTICLE_MOB_NAME = By.cssSelector("[class=\"article-title\"] h1");
        private static final By COMMENT_MOB_COUNT = By.cssSelector("[class=\"article-title\"] [class=\"commentCount\"]");

    public List<Article> firstFiveElements(List<WebElement> articles) {
        return firstFiveElements(articles, ARTICLE_TITLE, COMMENT);
    }

    public String Title(BaseFunc baseFunc) {
            return baseFunc.getArticle(ARTICLE_MOB_NAME).getText();
        }
        public int Comment(BaseFunc baseFunc) {
            return baseFunc.getCommentsCount(COMMENT_MOB_COUNT);
        }

    }