package test;

import org.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.Retry;

public class InvalidOrderTest extends BaseTest {

    @Test (groups = {"Invalid", "regression"}, retryAnalyzer = Retry.class)
    public void submitOrder_Invalid() throws Exception {

//        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
//        boolean match=productCatalogue.addProductToCart("Invalid Product");
//        //match=true;
//        Assert.assertFalse(match);
    }

}
