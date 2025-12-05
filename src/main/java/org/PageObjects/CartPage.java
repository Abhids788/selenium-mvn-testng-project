package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends abstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    By cartProductsBy=By.cssSelector(".cartSection h3");
    @FindBy(css=".cartSection h3")
        List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement checkoutButton;




    public boolean verifyProductInCart(String productName) {
        waitforElementToAppear(cartProductsBy);
        for (WebElement cartProduct : cartProducts) {
            if (cartProduct.getText().equalsIgnoreCase(productName)) {
                System.out.println("Product found in cart: " + productName);
                return true;
            }
        }
        return false;
    }

    public CheckoutPage clickCheckout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
