package Guru99.test;

import Guru99.base.testBase;
import Guru99.pages.CreateCustPage;
import Guru99.utilities.driverUtil;
import Guru99.utilities.loginUtil;
import Guru99.utilities.propertiesReaderUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Locale;

public class CustPgTest extends testBase {
    CreateCustPage CreateCustPage;

    @Test
    public void TC1_PosTest_NewCustVerfication(){
        Faker faker = new Faker();
        CreateCustPage = new CreateCustPage();
        driverUtil.getDriver().get(propertiesReaderUtil.getProperty("url"));
        loginUtil.pageLoginUtility();
        CreateCustPage.newCustBtn.click();
        Assert.assertEquals(driverUtil.getDriver().getTitle(), "Guru99 Bank New Customer Entry Page");

        CreateCustPage.custName.sendKeys("Jessicca Al");
        CreateCustPage.chooseGender("f");
        CreateCustPage.dob.sendKeys("04-05-1990");
        CreateCustPage.addrBox.sendKeys(faker.address().streetAddress());
        CreateCustPage.cityBox.sendKeys(faker.address().cityName());
        CreateCustPage.stateBox.sendKeys(faker.address().state());
        CreateCustPage.pinBox.sendKeys("987654");
        CreateCustPage.telephoneNo.sendKeys(faker.phoneNumber().subscriberNumber(9));
        CreateCustPage.email.sendKeys(faker.internet().emailAddress().toLowerCase(Locale.ROOT));
        CreateCustPage.password.sendKeys(faker.internet().password());
        CreateCustPage.submitBtn.click();

//        WebDriverWait wait = new WebDriverWait(driverUtil.getDriver(), 10);
//        WebElement subBtnClickable = wait.until(ExpectedConditions.elementToBeClickable(CreateCustPage.submitBtn));
//        subBtnClickable.click();

//        wait until clickable
//        WebDriverWait wait = new WebDriverWait(Scenario1Test.driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='brandSlider']/div[1]/div/div/div/img)[50]")));
//        element.click();


        Assert.assertEquals(CreateCustPage.custPageHeading.getText(), "Customer Registered Successfully!!!");
    }
}
