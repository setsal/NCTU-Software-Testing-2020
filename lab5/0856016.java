import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.firefox.FirefoxDriver;


class SeleniumTest {

    @Test
    public void SeleniumTest(){
        // for firefox
        /*
        System.setProperty("webdriver.gecko.driver","/home/setsal/tools/browser/geckodriver-v0.26/geckodriver");
        WebDriver driver = new FirefoxDriver();
        */

        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // browser visit to nctu.edu.tw
        driver.get("https://www.nctu.edu.tw");

        // Maximum the window size
        driver.manage().window().maximize();

        // click the latest news
        /* failed version :(
            WebElement res = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[@href='/news']"))));
            res.click();
            driver.findElement(By.xpath(("//li[@class='item-516']/a"))).click();
        */

        driver.findElement(By.xpath(("//a[@href='/news']"))).click();

        // click the second news
        driver.findElement(By.xpath(("//div[@id='modRandomArticle208']/div[2]/div[1]/h4[1]/a[1]"))).click();

        // print title
        System.out.println(driver.findElement(By.id("ar-header")).getText());

        // print content
        System.out.println(driver.findElement(By.className("itemFullText")).getText());

        // Go to google
        driver.get("https://www.google.com.tw");

        // Search with my student id number
        driver.findElement(By.name("q")).sendKeys("0856016");
        driver.findElement(By.name("btnK")).submit();

        // print the first one search result
        System.out.println(driver.findElement(By.xpath(("//div[@id='rso']/div[1]/div[1]/div[1]/a[1]/h3[1]"))).getText());

        // close the browser
        driver.quit();
    }
}