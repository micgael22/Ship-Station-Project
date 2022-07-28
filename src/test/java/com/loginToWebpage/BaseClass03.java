package com.loginToWebpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass03 {

    public String userName;
    public String userID;
    public String password;
    public WebDriver driver;
    public static Logger logR;
    public String url;
    public LoginPage logInP;
    PropertiesConfiguration config;

    @BeforeTest
    public void setup03() throws ConfigurationException {
        url = "http://demo.guru99.com/V4/";
        logR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            FileHandler fh = new FileHandler("myLogger.log");
            fh.setLevel(Level.ALL);
            logR.addHandler(fh);

        } catch (Exception e) {
            logR.log(Level.SEVERE, ">>>>File Logger not working<<<<");
        }

        //propertiesFile path
        config = new PropertiesConfiguration("src/main/resources/configDetails.properties");
    }

    @AfterTest
    public void afterTestO3() throws ConfigurationException {
        driver.quit();
        config.save();
        System.out.println(">>>>> configDetails.properties FILE<<<<< SUCCESSFULLY UPDATED!!");
    }
}
