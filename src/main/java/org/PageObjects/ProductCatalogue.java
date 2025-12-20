package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductCatalogue extends abstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @FindBy(css=".mb-3")
    List<WebElement> products;

    By productsBy=By.cssSelector(".mb-3");
    By toastMessage=By.cssSelector("#toast-container");

    public boolean addProductToCart(String productName) {
        waitforElementToAppear(productsBy);
        boolean flag=false;
        for (WebElement product : products) {
            if (product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)) {
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
                flag= true;

            }
        }
        waitforElementToAppear(toastMessage);
        waitforElementToDisappear(toastMessage);
        return flag;
    }
}
