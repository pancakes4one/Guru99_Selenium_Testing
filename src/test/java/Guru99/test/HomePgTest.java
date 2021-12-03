package Guru99.test;

import Guru99.base.testBase;
import Guru99.pages.HomePage;
import Guru99.pages.LoginPage;
import Guru99.utilities.driverUtil;
import Guru99.utilities.propertiesReaderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePgTest extends testBase {
    HomePage HomePage;
    LoginPage LoginPage;
    @Test
    public void TC1_verifyManagerId(){
        HomePage = new HomePage();
        LoginPage=new LoginPage();
        driverUtil.getDriver().get(propertiesReaderUtil.getProperty("url"));
        LoginPage.loginToThePage();
        Assert.assertTrue(HomePage.getMngrId().contains(propertiesReaderUtil.getProperty("username")));
    }


}
