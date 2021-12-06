package Guru99.pages;

import Guru99.utilities.driverUtil;
import Guru99.utilities.propReadUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //child class of TestBase

//    IN POM Design structure for each page :

//   1. @FindBy annotation to locate webElements.
//       -> Using this FindBy annotation, help us to locate web elements.
//   2. Create methods related webelements

    // locator for username box without PageFactory
    // By UsernameBox = By.name("uid");

    //PageFactory - OR (Object Repository)
    //creates a proxy that is faster than without it

    @FindBy(name = "uid")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    // will need methods to get this
//    @FindBy(name = "password")
//    private WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;
    // show difference with grabbing from parameters and from properties


    // the constructors (to initialize) and methods are for different features
    // on the page -- things I want to do on the page

   // initializing the page
    //made constructor (same name) instead of method to initialize

//   3.PageFactory.initElements(driver, this);
//		-> It creates connection in between driver and object of the class.

//    public LoginPage(){ PageFactory.initElements(driverUtil.getDriver(), this); }

    // up here too is the new class object I will be returning
    // show with void first
    public HomePage loginToThePage(String username, String password){
        // driver coming from TestBase class
        // you will initialize the driver with PageFactory
        // this means pointing to the current class object
        // look at the methods available
        // we used in TestBase and now here...
        //show PageFatory methods
        //PageFactory. ...
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
        return new HomePage();
        // returning the new class object for the next landing page
    }

    public String verifyLoginPageTitle() {
        return driverUtil.getDriver().getTitle(); }

}
