package Guru99.pages;

import Guru99.utilities.driverUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//table[@align='center']//tr//tr[3]//td")
    public WebElement mngrTextAndId;

    @FindBy(xpath = "//a[.='New Customer']")
    public WebElement createNewCustBtn;
    //next landing page

    @FindBy(xpath = "//a[.='Delete Customer']")
    public WebElement deleteCustBtn;
    //to next landing page


    //initialize with a constructor
    public HomePage(){ PageFactory.initElements(driverUtil.getDriver(), this); }

    //return title
    public String verifyHomePageTitle(){
        return driverUtil.getDriver().getTitle();
        //will Assert in the test
    }

    public String verifyHomePageManagerTextAndId(){ return mngrTextAndId.getText(); }

    public CreateCustPage landingPageNewCustomer(){
        createNewCustBtn.click();
        return new CreateCustPage();
        // returns next landing page object because the focus should
        // now be on that page
    }

    public DeleteCustPage clickDeleteCustomer(){
        deleteCustBtn.click();
        return new DeleteCustPage();
        //next landing page
    }

}
