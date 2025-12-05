package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationpage extends abstractComponent {
    WebDriver driver;
    public Confirmationpage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".hero-primary")
    WebElement confirmationMessage;

    public boolean confirmMessage() {
        waitforElementToAppear(By.cssSelector(".hero-primary"));
        String confirmMessage= confirmationMessage.getText();
        if(confirmationMessage.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.")) {
            System.out.println("Order placed successfully. Confirmation message: " + confirmMessage);
            return true;
        } else {
            System.out.println("Order placement failed or unexpected confirmation message: " + confirmMessage);
            return false;
        }

    }

}
