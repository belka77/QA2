package lession2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;


import java.util.List;

import static org.junit.Assert.*;

public class DelfiTest {
    private BaseFunc baseFunc = new BaseFunc();

    private static final String TITLE = "Ostapenko Maiami aizvada sezonas pirmo finālu pret 'US Open' čempioni Stīvensu";
    private static final String MAIN_PAGE_WEB_URL = "http://www.delfi.lv/";
    private static final String MAIN_PAGE_MOBILE_URL = "http://m.delfi.lv/";


    private static final Logger LOGGER = LogManager.getLogger(DelfiTest.class);


    @Test
    public void delfiTest() {

        baseFunc.goToUrl(MAIN_PAGE_WEB_URL);
        LOGGER.info("We are starting!");

        HomePage homePage = new HomePage(baseFunc);

        List<WebElement> articleTitles = homePage.getAllTitles();

        assertTrue("Title list is empty", articleTitles.size() != 0);

        boolean isTitlePresent = false;
        for (WebElement articleTitle : articleTitles) {
            if (articleTitle.getText().equals(TITLE)) {
                isTitlePresent = true;
                break;
            }
            assertTrue("Article is not found", isTitlePresent);
        }

        baseFunc.goToUrl(MAIN_PAGE_MOBILE_URL);

        MobileHomePage mobileHomePage = new MobileHomePage(baseFunc);

        List<WebElement> mobileArticleTitles = mobileHomePage.getAllTitles();


        assertTrue("Title list is empty", mobileArticleTitles.size() != 0);

        isTitlePresent = false;
        for (WebElement mobileArticleTitle : mobileArticleTitles) {
            if (mobileArticleTitle.getText().equals(TITLE)) {
                isTitlePresent = true;
                break;
            }
            assertTrue("Article is not found", isTitlePresent);
        }
    }
}