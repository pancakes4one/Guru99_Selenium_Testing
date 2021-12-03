package Guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CreateCustPage extends BasePage{

    //    Step 1) Go to Guru99 Demo Site   http://demo.guru99.com/V4/
//    Step 2) In Login page check text "Guru99 Bank" is present
//    Step 3) Login into application  with given credentials
//    Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
//    Step 5) Click on new customer button and verify you are in New Customer Entry Page
//    Step 6) Fill the information for new customer
//    Step 7) Verify new customer added successfully

    @FindBy(xpath = "//a[.='New Customer']")
    public WebElement newCustBtn;

    @FindBy(className = "heading3")  // why didn't p.heading3 work for CSS?
    public WebElement custPageHeading;

    @FindBy(name = "name")
    public WebElement custName;

    @FindBy(name = "rad1")
    public List<WebElement> genders;

    public void chooseGender(String genderInput){
        for (WebElement gender : genders){
            if (gender.getAttribute("value").equalsIgnoreCase(genderInput));
            gender.click();
            Assert.assertTrue(gender.isSelected());
        }
    }

    @FindBy(id = "dob")
    public WebElement dob;

    @FindBy(name = "addr")
    public WebElement addrBox;

    @FindBy(name = "city")
    public WebElement cityBox;

    @FindBy(name = "state")
    public WebElement stateBox;

    @FindBy(name = "pinno")
    public WebElement pinBox;

    @FindBy(name = "telephoneno")
    public WebElement telephoneNo;

    @FindBy(name = "emailid")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(name = "sub")
    public WebElement submitBtn;

    @FindBy(name = "res")
    public WebElement resetBtn;

}
