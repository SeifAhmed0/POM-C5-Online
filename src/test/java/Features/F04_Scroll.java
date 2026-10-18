package Features;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F04_Scroll {
    WebDriver driver;

    @BeforeMethod
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
    }
    @Test
    void TCA(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,2000)");

        WebElement element = driver.findElement(By.id("target"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
