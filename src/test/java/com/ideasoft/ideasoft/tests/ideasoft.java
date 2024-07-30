package com.ideasoft.ideasoft.tests;

import com.ideasoft.framework.core.Commands;
import com.ideasoft.ideasoft.core.BaseTest;

import com.ideasoft.ideasoft.pages.ideasoftPage;
import org.testng.annotations.Test;

public class ideasoft extends BaseTest
{
    ideasoftPage ideasoftPage;


    @Test(testName = "ideasoft")
    void Test1()
    {
        ideasoftPage = new ideasoftPage(getDriver());

        ideasoftPage.searchOnIdeasoft("ürün");
        ideasoftPage.goToDetail();
        ideasoftPage.addtoBasket();
        ideasoftPage.verifySuccessMessage("SEPETİNİZE EKLENMİŞTİR");
        ideasoftPage.goToBasket("5");
    }

}
