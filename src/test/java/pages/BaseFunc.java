package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BaseFunc {
    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://"))
            url = "http://" + url;
        driver.get(url);
    }

    public void ClosePage() {
        this.driver.close();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);

        public List<WebElement> getArticles (By locator){
            return driver.findElements(locator);
        }
        public WebElement getArticles (By locator)
        return driver.findElement(locator);

    }
    public WebElement getArticle(By locator){
        return driver.findElement(locator);
    }

    public int getCommentsCount(By locator){
        List<WebElement> list = this.getElements(locator);
        if (list.isEmpty())
        {
            return 0;
        }
        else {
            String count = list.get(0).getText();
            count  = count.replace("(","");
            count  = count.replace(")", "");
            return Integer.valueOf(count);

        }
    }
}

