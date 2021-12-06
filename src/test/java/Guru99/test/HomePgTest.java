package Guru99.test;

import Guru99.base.testBase;
import Guru99.pages.HomePage;
import Guru99.pages.LoginPage;
import Guru99.pages.TestBase;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propReadUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePgTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    //everything is chained
    //test cases should be separate, independent of each other
    //@before each we should launch browser and login
    //@test then execute test case
    //@after then close

    // could use methods and test to initialize this webpage
    // Naveen 37 mins on part 3 POM for his way

//    tried a constructor but that didn't work either
//    public HomePgTest(){
//        loginPage = new LoginPage();
//        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
//    }
//
//    Tried a before Test but it didn't work
//    @BeforeTest
//    public void setUp(){
//        loginPage = new LoginPage();
//        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
//    }

    // in this way each test is entirely independent

    @Test
    public void TC1_Guru99_VerifyTitle_HomePageTest(){
        //need access to the login page
        loginPage = new LoginPage();
        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
        String homePageTitle = homePage.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle,"Guru99 Bank Manager HomePage", "!-- HomePage Title Does NOT MATCH --!");
    }

    @Test
    public void TC2_Guru99_VerifyManagerTextAndIdDisplayed_HomePageTest(){
        loginPage = new LoginPage();
        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
        Assert.assertEquals(homePage.verifyHomePageManagerTextAndId(), "Manger Id : mngr368294", "!-- Correct Manager Text Not Displayed --!");
    }




}
