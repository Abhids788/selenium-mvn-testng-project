package testComponents.Helper;
import org.testng.annotations.DataProvider;


public class Data {

    @DataProvider(name = "products")
    public Object[][] dataProviderProducts() {
        return new Object[][] {
            {"adidas original", "India"},
            {"ZARA COAT 3","germany"},
        };
    }
}
