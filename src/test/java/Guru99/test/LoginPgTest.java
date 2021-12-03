package Guru99.test;

import Guru99.pages.LoginPage;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propertiesReaderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPgTest {

    LoginPage LoginPage;

    @Test
    public void TC1_Guru99_PositiveLogin(){
        //positive login
        LoginPage = new LoginPage();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(“//div[contains(text(),’COMPOSE’)]”)));
        driverUtil.getDriver().get(propertiesReaderUtil.getProperty("url"));
        driverUtil.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage.loginToThePage();
    }

//    @Test
//    public void TC2_Guru99_VerifyTitle(){
//        Assert.assertTrue(LoginPage.getTitle().contains()
//    }


}
