package Guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//table[@align='center']//tr//tr[3]//td")
    public WebElement mngrId;

    public String getMngrId(){ return mngrId.getText(); }

}
