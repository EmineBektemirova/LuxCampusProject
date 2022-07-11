package TestPages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

class DriverSetUp {
    public static WebDriver driver;

    public DriverSetUp () {
        System.setProperty("webdriver.chrome.driver", "/Users/viktor/Documents/Emine/IT/chromedriver 103");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600L));
    }
}
