package Guru99.utilities;

import Guru99.pages.LoginPage;
import Guru99.pages.TestBase;

public class commonUtil extends TestBase {  // don't need anymore

    public void switchToFrame(String frameName){
        driverUtil.getDriver().switchTo().frame("frameName");
    }

}
