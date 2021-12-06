package Guru99.test;

import Guru99.base.testBase;
import Guru99.pages.CreateCustPage;
import Guru99.pages.HomePage;
import Guru99.pages.LoginPage;
import Guru99.pages.TestBase;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propReadUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class CustPgTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage; //null
    CreateCustPage createCustPage;

    @Test (testName = "Guru99_CreateCustomerPage_1")
    public void TC1_TitleVerify(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
        createCustPage = new CreateCustPage();
        createCustPage = homePage.landingPageNewCustomer();
        Assert.assertEquals(createCustPage.verifyCreateCustPageTitle(), "Guru99 Bank New Customer Entry Page");
    }

    @Test (testName = "Guru99_CreateCustomerPage_2")
    public void TC2_VerifySuccessful_CreateNewCust(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        homePage = loginPage.loginToThePage(propReadUtil.getProperty("username"),propReadUtil.getProperty("password"));
        createCustPage = new CreateCustPage();
        createCustPage = homePage.landingPageNewCustomer();
        //methods to create new customer
        createCustPage.setManualCustInfo("Julia", "F", "05-06-1988", "678678");
        createCustPage.setFakerInfo();
        webDriverWait.until(ExpectedConditions.stalenessOf(createCustPage.password)); //if needed
        createCustPage.submitBtn.click();
        //cust page heading must match
        Assert.assertEquals(createCustPage.custPageHeading.getText(), "Customer Registered Successfully!!!");
    }

//        WebDriverWait wait = new WebDriverWait(driverUtil.getDriver(), 10);
//        WebElement subBtnClickable = wait.until(ExpectedConditions.elementToBeClickable(CreateCustPage.submitBtn));
//        subBtnClickable.click();

//        wait until clickable
//        WebDriverWait wait = new WebDriverWait(Scenario1Test.driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='brandSlider']/div[1]/div/div/div/img)[50]")));
//        element.click();
//        }
}
