package com.ideasoft.ideasoft.core;

import com.ideasoft.framework.core.CommonTest;
import configs.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends CommonTest {

    ConfigFileReader configFileReader;

    // Runs before each method
    @BeforeMethod(groups = {"Regression", "Smoke","Integration"})
    public void start() {
        WebDriver driver = getDriver();
        configFileReader = new ConfigFileReader();
        driver.get(ConfigFileReader.fileProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    // @AfterMethod
    // Runs after each method
    @AfterMethod()
    public void end() {

    }
}
