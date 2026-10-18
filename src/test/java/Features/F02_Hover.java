package Features;

import Pages.P01_HomePage;
import Pages.P04_HoverPage;
import Pages.P05_HoverAssertionPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class F02_Hover {
    WebDriver driver;
    P01_HomePage Hp;
    P04_HoverPage HvP;
    P05_HoverAssertionPage HvAP;

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Hp = new P01_HomePage(driver);
        HvP = new P04_HoverPage(driver);
        HvAP = new P05_HoverAssertionPage(driver);
    }

    @Test
    @Epic("Hover Epic")
    @Feature("Hover Feature")
    @Description("The Hover Test Case tests and ensures hovering functionality works correctly")
    @Severity(SeverityLevel.CRITICAL)
    void hover(){
        Allure.step("The user clicks on hovers at Home page");
        Hp.hoversClick();
        Allure.step("The user hovers on the image");
        HvP.hoverImg();
        Allure.step("The user clicks on View Profile once it shows up after hovering");
        HvP.viewProfileClick();
        Allure.step("The user got navigated to the right page");
        HvAP.validateSuccessHover();
    }

    @AfterMethod
    void tearDown(){}
}

