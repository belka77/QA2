package lession2;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This is a JavaGuru home page test
 */
public class JavaGuruHomePageTest {
    private static final By QA_COURSE_MENU_LINK = By.xpath(".//span[text()='Курс Тестирования(QA)']");
    private static final String HOME_PAGE = "http://javaguru.lv/";

    @Test
    public void Delfi() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver ();
        driver.manage() .window() .maximize();
        driver.get(HOME_PAGE);
        WebElement articleTitle = driver.findElement (By.id("id"));
        driver.findElement(QA_COURSE_MENU_LINK).click();
        Assert.assertEquals("Title is wrong!", "Ushakov privet!", articleTitle.getText());
    }
}
