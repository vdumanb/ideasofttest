package com.ideasoft.framework.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class Commands {
    public static void Click(WebElement webElement) {
        WaitUntilVisible(webElement);
        WaitUntilClickable(webElement);
        scrollToElement(webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) CommonTest.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }


    public static void scrollToElement(WebElement element) {
        Actions actions = new Actions(CommonTest.getDriver());
        actions.scrollToElement(element).perform();
    }


    public static void SendKeys(WebElement webElement, String string) {
        WaitUntilVisible(webElement);
        scrollToElement(webElement);
        ClearArea(webElement);
        try {
            webElement.sendKeys(string);
        } catch (Exception e) {
            JavascriptExecutor ex = (JavascriptExecutor) CommonTest.getDriver();
            ex.executeScript("arguments[0].value='" + string + "';", webElement);
        }
    }
    public static void ClearArea(WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }


    public static String GetText(WebElement webElement) {
        WaitUntilVisible(webElement);
        return webElement.getText();
    }

    public static void WaitUntilClickable(WebElement element) {
        //WebDriverWait wait = new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void WaitUntilVisible(WebElement element) {
        CommonTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        int attempts = 0;
        while(attempts < 15) {
            try {
                WebDriverWait wait = new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(1));
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch(Exception e) {
                //e.printStackTrace();
            }
            attempts++;
        }
        CommonTest.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void Delay(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
