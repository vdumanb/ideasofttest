package com.ideasoft.framework.core;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Asserts {
    public static void AssertTrue(WebElement webElement, String string) {
        String result = Commands.GetText(webElement);
        Assert.assertTrue(result.equals(string), webElement.getText());
    }
}