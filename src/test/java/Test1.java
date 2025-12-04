import org.PageObjects.LandingPage;
import org.PageObjects.ProductCatalogue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("This is Test1 class");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        LandingPage landingPage= new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");

        ProductCatalogue productCatalogue= new ProductCatalogue(driver);
        productCatalogue.addProductToCart();
    }
}
