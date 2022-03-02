package com.us13_Pair1;

import com.utilities.BrowserUtils;
import com.utilities.CRM_Utilities;
import com.utilities.ConfigurationReader;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class US13_TC1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("env2"));
        //1-User on the homepage
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("usernameHelp1"), ConfigurationReader.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        BrowserUtils.sleep(2);
        driver.close();

    }
}
