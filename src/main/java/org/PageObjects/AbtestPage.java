package org.PageObjects;

import org.AbstractComponents.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbtestPage extends abstractComponent {
    WebDriver driver;
    public AbtestPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div.large-12 h3")
    WebElement pageHeader;

    @FindBy(css="div.large-12 p")
    WebElement pageDescription;

    public String getPageHeader(){
        return pageHeader.getText();
    }

    public String getPageDescription(){
        return pageDescription.getText();
    }
}
