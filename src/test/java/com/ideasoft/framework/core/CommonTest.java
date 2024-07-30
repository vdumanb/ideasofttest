package com.ideasoft.framework.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class CommonTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(groups = {"Regression", "Smoke","Integration"})
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver.set(new ChromeDriver(chromeOptions));
    }

    @AfterMethod(groups = {"Regression", "Smoke", "Integration"})
    public void tearDown() {
        getDriver().quit();
    }

}
