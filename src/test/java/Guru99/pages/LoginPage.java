package Guru99.pages;

import Guru99.utilities.driverUtil;
import Guru99.utilities.propertiesReaderUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "uid")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;

    public void loginToThePage(){
        usernameBox.sendKeys(propertiesReaderUtil.getProperty("username"));
        passwordBox.sendKeys(propertiesReaderUtil.getProperty("password"));
        loginBtn.click();
    }

    public String getTitle() { return driverUtil.getDriver().getTitle(); }

}
