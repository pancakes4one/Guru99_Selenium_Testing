package Guru99.pages;

import Guru99.utilities.driverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriverWait webDriverWait = new WebDriverWait(driverUtil.getDriver(), 15);
    public BasePage() {
        PageFactory.initElements(driverUtil.getDriver(),this);
    }
}
