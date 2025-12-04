package org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement useremail;

    @FindBy(id="userPassword")
    WebElement userpassword;

    @FindBy(id="login")
    WebElement loginBtn;

    public void loginToApplication(String email, String password){
        useremail.sendKeys(email);
        userpassword.sendKeys(password);
        loginBtn.click();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
