package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends abstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".action__submit")
    WebElement submitOrderButton;

    @FindBy(css="[placeholder='Select Country']")
    WebElement countryInput;

    @FindBy(css=".ta-results button")
    List<WebElement> countryResults;

    public void fillCheckoutDetails(String countryName){
        Actions a=new Actions(driver);
        a.sendKeys(countryInput,"ind").build().perform();
        waitforElementToAppear(By.cssSelector(".ta-results"));
//        List<WebElement> countries=driver.findElements(By.cssSelector(".ta-results button"));
        for(WebElement country:countryResults) {
            if(country.getText().equalsIgnoreCase(countryName)) {
                country.click();
                break;
            }
        }
    }


    public Confirmationpage clickSubmitOrder() {
        submitOrderButton.click();
        return new Confirmationpage(driver);
    }
}
