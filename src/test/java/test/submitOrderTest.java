package test;

import com.aventstack.extentreports.ExtentReports;
import org.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;
import testComponents.Helper.Data;

public class submitOrderTest extends BaseTest {
    ExtentReports extentsTest;


    @Test(dataProvider = "products", dataProviderClass = Data.class, groups = {"regression", "smoke"})
    public void submitOrder_adidas_original(String productName, String countryName) throws Exception {

        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
        productCatalogue.addProductToCart(productName);
        CartPage cartPage=productCatalogue.goToCartPage();
        boolean match= cartPage.verifyProductInCart(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.clickCheckout();
        checkoutPage.fillCheckoutDetails(countryName);
        Confirmationpage confirmationpage=checkoutPage.clickSubmitOrder();
        Assert.assertTrue(confirmationpage.confirmMessage());
    }

//    @Test
//    public void submitOrder_ZARA_COAT() throws Exception {
//        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
//        productCatalogue.addProductToCart("ZARA COAT 3");
//        CartPage cartPage=productCatalogue.goToCartPage();
//        boolean match= cartPage.verifyProductInCart("ZARA COAT 3");
//        Assert.assertTrue(match);
//        CheckoutPage checkoutPage= cartPage.clickCheckout();
//        checkoutPage.fillCheckoutDetails("India");
//        Confirmationpage confirmationpage=checkoutPage.clickSubmitOrder();
//        Assert.assertTrue(confirmationpage.confirmMessage());
//    }
}
