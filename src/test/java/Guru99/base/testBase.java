package Guru99.base;

import Guru99.utilities.driverUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class testBase {

    //    Step 1) Go to Guru99 Demo Site   http://demo.guru99.com/V4/
//    Step 2) In Login page check text "Guru99 Bank" is present
//    Step 3) Login into application  with given credentials
//    Step 4) Verify that the Home page contains text as "Manger Id: mngr368294"
//    Step 5) Click on new customer button and verify you are in New Customer Entry Page
//    Step 6) Fill the information for new customer
//    Step 7) Verify new customer added successfully


    @BeforeMethod
    public void setUp(){
        driverUtil.getDriver().manage().window().maximize();
        driverUtil.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
//        driverUtil.closeDriver();
    }
}
