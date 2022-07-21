package com.loginToWebpage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_16_Amy extends BaseClass03{
    @Test
    public void loginTest16() {

        //Login Details
        userID = "mngr423973";
        password = "tegajAg";

        driver.get(url);

        logR.info("URL is open");
        logInP = new LoginPage(driver);

        logInP.setUserID(userID);
        logR.info("Entered UserName");

        logInP.setPassword(password);
        logR.info("Entered Password");

        logInP.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logR.info("Login test Password");
        } else {
            Assert.assertTrue(false);
            logR.info("Login test failed");
        }
        System.out.println(">>> Amy insert login details successfully!! <<<");
    }
}
