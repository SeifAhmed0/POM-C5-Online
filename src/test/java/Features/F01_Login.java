package Features;

import Pages.P01_HomePage;
import Pages.P02_LoginPage;
import Pages.P03_LoginAssertionPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestNGListeners.CustomeListeners.class)
public class F01_Login {
    WebDriver driver;
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    P01_HomePage Hp;
    P02_LoginPage Lp;
    P03_LoginAssertionPage Lap;

    @BeforeMethod
    void setUp(){
        driver = ThreadGuard.protect(new ChromeDriver());
        driverThreadLocal.set(driver);
        driverThreadLocal.get().get("https://the-internet.herokuapp.com/");
        Hp = new P01_HomePage(driverThreadLocal.get());
        Lp = new P02_LoginPage(driverThreadLocal.get());
        Lap = new P03_LoginAssertionPage(driverThreadLocal.get());
    }

    @Test
    @Epic("Authentication Epic")
    @Feature("Login Feature")
    @Description("The Valid Login Test Case tests and ensures Login functionality works correctly with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    void validLogin(){
        Allure.step("The user clicks on Authentication at Home page");
        Hp.fromAuthClick();
        Allure.step("The user inserts a valid credential and clicks on Login Button");
        Lp.loginInsert("tomsmith","SuperSecretPassword!");
        Allure.step("The user got navigated to the right page");
        Lap.validateSuccessMsg();
    }

    @Test
    @Epic("Authentication Epic")
    @Feature("Login Feature")
    @Description("The Invalid Login Password Test Case tests and ensures Login functionality works correctly with invalid password")
    @Severity(SeverityLevel.CRITICAL)
    void invalidLoginPassword(){
        Allure.step("The user clicks on Authentication at Home page");
        Hp.fromAuthClick();
        Allure.step("The user inserts a valid username and an invalid password and clicks on Login Button");
        Lp.loginInsert("tomsmith","123456");
        Allure.step("The user is still on the Login page and the error message shows up");
        Lp.validateErrorMsg();
    }

    @Test
    @Epic("Authentication Epic")
    @Feature("Login Feature")
    @Description("The Invalid Login Username Test Case tests and ensures Login functionality works correctly with invalid username")
    @Severity(SeverityLevel.CRITICAL)
    void invalidLoginUsername(){
        Allure.step("The user clicks on Authentication at Home page");
        Hp.fromAuthClick();
        Allure.step("The user inserts an invalid username and a valid password and clicks on Login Button");
        Lp.loginInsert("seif","SuperSecretPassword!");
        Allure.step("The user is still on the Login page and the error message shows up");
        Lp.validateErrorMsg();
    }

    @AfterMethod
    void tearDown(){
            driverThreadLocal.get().quit();
    }
}
