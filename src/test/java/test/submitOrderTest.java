package test;

import org.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.FileNotFoundException;

public class submitOrderTest extends BaseTest {

    @Test
    public void submitOrder_adidas_original() throws Exception {
        //LandingPage landingPage=launchApplication();

        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
        productCatalogue.addProductToCart("adidas original");
        CartPage cartPage=productCatalogue.goToCartPage();
        boolean match= cartPage.verifyProductInCart("adidas original");
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.clickCheckout();
        checkoutPage.fillCheckoutDetails("India");
        Confirmationpage confirmationpage=checkoutPage.clickSubmitOrder();
        Assert.assertTrue(confirmationpage.confirmMessage());
    }

    @Test
    public void submitOrder_ZARA_COAT() throws Exception {
        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
        productCatalogue.addProductToCart("ZARA COAT 3");
        CartPage cartPage=productCatalogue.goToCartPage();
        boolean match= cartPage.verifyProductInCart("ZARA COAT 3");
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.clickCheckout();
        checkoutPage.fillCheckoutDetails("India");
        Confirmationpage confirmationpage=checkoutPage.clickSubmitOrder();
        Assert.assertTrue(confirmationpage.confirmMessage());
    }
}
