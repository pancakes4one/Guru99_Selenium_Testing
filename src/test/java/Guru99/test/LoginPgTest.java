package Guru99.test;

import Guru99.pages.HomePage;
import Guru99.pages.LoginPage;
import Guru99.pages.TestBase;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propReadUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPgTest extends TestBase { // creating inside test package
    // extends testBase
     LoginPage loginPage;
     // we already have this new HomePage from our TestBase


    @Test (priority = 1)
    public void TC1_Guru99_PositiveLogin_LoginPageTest(){
        //positive login
        //my test script is now so short
        loginPage = new LoginPage();
        loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));

    }

    @Test (priority = 2)
    public void TC2_Guru99_VerifyTitle_LoginPageTest(){
        loginPage = new LoginPage();
        loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
        Assert.assertEquals(loginPage.verifyLoginPageTitle(), "Guru99 Bank Manager HomePage");
    // will return true or false
    }


//    example of a negative login test
//    day 10 class 1
//    @Test
//    public void TC1_SBNegativeTest(){
//        smartBearLoginPage=new SmartBearLoginPage();
//        DriverUtil.getDriver().get(PropertiesReadingUtil.getProperties("SmartBear_url"));
//        smartBearLoginPage.loginSmartBear(PropertiesReadingUtil.getProperties("SmartBear_invalid_username")
//                ,PropertiesReadingUtil.getProperties("SmartBear_invalid_password"));
//
//        String expectedMessage="Invalid Login or Password.";
////        WebElement statusElement=smartBearLoginPage.getStatusMassegeElement();
////        String actualText=statusElement.getText();
//        String actualText2=smartBearLoginPage.getStatusMessage();
//
//        Assert.assertEquals(expectedMessage,actualText2,"negative login failed!!!!");
//    }

}
