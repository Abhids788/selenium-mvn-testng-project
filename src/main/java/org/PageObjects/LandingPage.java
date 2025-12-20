package org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div.large-12 a")
    List<WebElement> pageLink;



    public AbtestPage clickOnAbtest(){
        for(WebElement link : pageLink){
            if(link.getText().equalsIgnoreCase("A/B Testing")){
                link.click();
                break;
            }
        }
        return new AbtestPage(driver);
    }

    public void goTo(String url){
        driver.get(url);
    }

}
