package test;

import com.aventstack.extentreports.ExtentReports;
import org.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.Helper.Data;

public class AB_PageTests extends BaseTest {
    ExtentReports extentsTest;


    @Test(groups = {"regression", "smoke"})
    public void AB_PageHeaderTest() throws Exception {
        AbtestPage abtestPage =landingPage.clickOnAbtest();
        Assert.assertTrue(abtestPage.getPageHeader().equals("A/B Test Control")
                || abtestPage.getPageHeader().equals("A/B Test Variation 1"));
    }

    @Test(groups = {"regression", "smoke"})
    public void AB_PageDescriptionTest() throws Exception {
        String expectedDescription1 = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";
        AbtestPage abtestPage =landingPage.clickOnAbtest();
        Assert.assertEquals(expectedDescription1, abtestPage.getPageDescription());
    }


}
