package pages;

import org.openqa.selenium.By;

public class ArticleMobilePage {

    private static final By TITLE = By.xpath(".//a[contains(@class, 'md-scrollpos')]");
    private static final By COMMENTS = By.xpath(".//a[contains(@class, 'commentCount')]");
    BaseFunc baseFunc ;

    public ArticleMobilePage (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
}
