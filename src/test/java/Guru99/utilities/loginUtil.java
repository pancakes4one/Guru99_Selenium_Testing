package Guru99.utilities;

import Guru99.pages.LoginPage;

public class loginUtil {
    LoginPage LoginPage;

    public static void pageLoginUtility(){
        LoginPage LoginPage = new LoginPage();
        LoginPage.loginToThePage();
    }
}
