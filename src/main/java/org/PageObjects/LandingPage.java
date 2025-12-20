package org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 8bbf9d5fb00642cb1c4896fa47c64bcdce963000
public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

<<<<<<< HEAD
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
=======
    @FindBy(id="userEmail")
    WebElement useremail;

    @FindBy(id="userPassword")
    WebElement userpassword;

    @FindBy(id="login")
    WebElement loginBtn;

    public ProductCatalogue loginToApplication(String email, String password){
        useremail.sendKeys(email);
        userpassword.sendKeys(password);
        loginBtn.click();
        return new ProductCatalogue(driver);
>>>>>>> 8bbf9d5fb00642cb1c4896fa47c64bcdce963000
    }

    public void goTo(String url){
        driver.get(url);
    }

}
