package Cross_Browser_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTCs {

    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "webAppURL"})
    public void setUp(String browser, String webAppURL){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.get(webAppURL);
        driver.manage().window().maximize();
    }

    @Test
    void TC_A(){
        System.out.println("Test Case Executed!");
    }

    @AfterMethod
    public void tearDown(){}
}
