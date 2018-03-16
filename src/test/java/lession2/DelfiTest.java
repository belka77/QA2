package lession2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

import static org.junit.Assert.*;

public class DelfiTest {
    private static final String TITLE = "Baņķieru drāmas mēnesis: 10 būtiskākie Dombura secinājumi un jautājumi";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";
    private static final By ARTICLE_TITLE = By.xpath("//a[@class='top2012-title']");
    private static final By ARTICLE_TITLE_MOBILE = By.xpath("//a[@class='md-scrollpos']");
    private static final Logger LOGGER = LogManager.getLogger (DelfiTest.class);


    @Test
    public void delfiTest() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LOGGER.info("We are starting!");
        driver.get(MAIN_PAGE_WEB_URL);

        List<WebElement> articleTitles = driver.findElements(ARTICLE_TITLE);
        assertTrue("Title list is empty", articleTitles.size() != 0);
        boolean isTitlePresent = false;
        for (WebElement articleTitle : articleTitles) {
            if (articleTitle.getText().equals(TITLE)) {
                isTitlePresent = true;
                break;
            }
            assertTrue("Article is not found", isTitlePresent);
        }

        driver.get(MAIN_PAGE_MOBILE_URL);
        List<WebElement> mobileArticleTitles = driver.findElements(ARTICLE_TITLE_MOBILE);
        assertTrue("Title list is empty", articleTitles.size() != 0);
        isTitlePresent = false;
        for (WebElement articleTitle : mobileArticleTitles) {
            if (articleTitle.getText().equals(TITLE)) {
                isTitlePresent = true;
                break;
            }
            assertTrue("Article is not found", isTitlePresent);
        }
    }

    private void someFunction() {

    }
}