package Guru99.pages;

import Guru99.base.testBase;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propReadUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //because we can't instantiate an abstract class
    // this is my parent class to extend to individual pages

    // before anything else, static method -- name of the class
    // constructors must be the name of the class
    public TestBase() {
        PageFactory.initElements(driverUtil.getDriver(),this);
    }

    @BeforeMethod
    //instead of before method because if I do it before method
    //then I need to change in my test cases that they will be running in
    //separate windows and all need logins in my manager test cases
    //but if not, then all manager test cases will run in one window
    // another was is Naveen's way to do a super class to then call
    // to initialize in each test
    public void setUp(){
        //already
        driverUtil.getDriver().manage().window().maximize();
        // could also make a util page for this to define the time amounts
        // or can leave here  // class name would be
        // public class TestUtil // and method name would be
        // public static long IMPLICIT_WAIT = 20;
        driverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driverUtil.getDriver().get(propReadUtil.getProperty("url"));
    //can get the url here or in my class page
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driverUtil.closeDriver();
    }

    // will extend to all our classes to use on elements
    protected WebDriverWait webDriverWait = new WebDriverWait(driverUtil.getDriver(), 15);

//    other helpful ways to call the method that come from protected WebDriverWait
//    that we can use in our classes
//    public void clickTimerButton(){//timerButton.click();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
//    }

//    public WebElement getWebDriverText(){
//        webDriverWait.until(ExpectedConditions.visibilityOf(webDriverText));
//        System.out.println("webDriverText.getText() = " + webDriverText.getText());
//        return webDriverText;


}
