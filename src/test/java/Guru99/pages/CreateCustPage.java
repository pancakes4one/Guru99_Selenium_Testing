package Guru99.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Guru99.utilities.driverUtil;

import java.util.List;
import java.util.Locale;

public class CreateCustPage extends TestBase {

    //    Step 1) Go to Guru99 Demo Site   http://demo.guru99.com/V4/
//    Step 2) In Login page check text "Guru99 Bank" is present
//    Step 3) Login into application  with given credentials
//    Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
//    Step 5) Click on new customer button and verify you are in New Customer Entry Page
//    Step 6) Fill the information for new customer
//    Step 7) Verify new customer added successfully

//    @FindBy(xpath = "//a[.='New Customer']")
//    public WebElement newCustBtn;


    public CreateCustPage(){ PageFactory.initElements(driverUtil.getDriver(), this); }

    @FindBy(className = "heading3")  // why didn't p.heading3 work for CSS?
    public WebElement custPageHeading;

    @FindBy(name = "name")
    public WebElement custName;

    @FindBy(name = "rad1")
    public List<WebElement> genderRadioBtns;

    public void chooseGender(String genderInput) {
        for (WebElement gender : genderRadioBtns) {
            if (gender.getAttribute("value").equalsIgnoreCase(genderInput)) ;
            gender.click();
//            Assert.assertTrue(gender.isSelected());
            // no assertions should be here
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


    public String verifyCreateCustPageTitle(){
        return driverUtil.getDriver().getTitle();
    }

    public void setManualCustInfo(String name, String gender, CharSequence dateOfBirth, CharSequence sixDigitPin){
        custName.sendKeys(name);
        chooseGender(gender);
        dob.sendKeys(dateOfBirth);
        pinBox.sendKeys("987654");
    }

    public void setFakerInfo(){
        Faker faker = new Faker();
        addrBox.sendKeys(faker.address().streetAddress());
        cityBox.sendKeys(faker.address().cityName());
        stateBox.sendKeys(faker.address().state());
        telephoneNo.sendKeys(faker.phoneNumber().subscriberNumber(9));
        email.sendKeys(faker.internet().emailAddress().toLowerCase(Locale.ROOT));
        password.sendKeys(faker.internet().password());
    }

}



