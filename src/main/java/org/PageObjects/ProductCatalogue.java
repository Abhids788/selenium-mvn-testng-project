package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(css=".card-body")
    List<WebElement> products;

    By productsBy=By.cssSelector(".card-body");

    //@FindBy(css="#toast-container")
    By toastMessage=By.cssSelector("#toast-container");

    public void addProductToCart() {
        waitforElementToAppear(productsBy);
        for (WebElement product : products) {
            if (product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original")) {
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
            }
        }
        waitforElementToAppear(toastMessage);
        waitforElementToDisappear(toastMessage);

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
    }
}
