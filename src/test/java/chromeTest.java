import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeTest {
    public static void main(String[] args) {
        System.out.println("This is a test class for Chrome.");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.gmail.com");
    }
}
