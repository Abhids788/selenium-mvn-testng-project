import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class
chromeTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is a test class for Chrome.");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //driver.get("https://demoqa.com/");
        driver.get("https://rahulshettyacademy.com/client");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.id("userEmail")).sendKeys("abhids791@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Asd@12345");
        driver.findElement(By.id("login")).click();

        Thread.sleep(2000);

        //Add Product to Cart
        List<WebElement> list=driver.findElements(By.cssSelector(".card-body"));
        for(WebElement e:list) {
            if(e.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("adidas original")) {
                e.findElement(By.cssSelector(".card-body button:last-of-type")).click();
            }
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
        driver.findElements(By.cssSelector(".cartSection h3")).forEach(cartProduct->{
            if(cartProduct.getText().equalsIgnoreCase("adidas original")) {
                System.out.println("Product is present in the cart");
            }
        });

        driver.findElement(By.cssSelector(".totalRow button")).click();


        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"ind").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        List<WebElement> countries=driver.findElements(By.cssSelector(".ta-results button"));
        for(WebElement country:countries) {
            if(country.getText().equalsIgnoreCase("India")) {
                country.click();
                break;
            }
        }

        driver.findElement(By.cssSelector(".action__submit")).click();

        Thread.sleep(2000);

        String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
        System.out.println(confirmMessage);
        driver.findElement(By.cssSelector(".hero-primary")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.");

        driver.close();

    }
}
