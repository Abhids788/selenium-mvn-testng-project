import org.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Test1  {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("This is Test1 class");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        LandingPage landingPage= new LandingPage(driver);

        landingPage.goTo();
        ProductCatalogue productCatalogue =landingPage.loginToApplication("abhids791@gmail.com", "Asd@12345");
        productCatalogue.addProductToCart("adidas original");
        CartPage cartPage=productCatalogue.goToCartPage();


        boolean match= cartPage.verifyProductInCart("adidas original");
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.clickCheckout();


        checkoutPage.fillCheckoutDetails("India");
        Confirmationpage confirmationpage=checkoutPage.clickSubmitOrder();


        Assert.assertTrue(confirmationpage.confirmMessage());

        driver.close();

    }
}
