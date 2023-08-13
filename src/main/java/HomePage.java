import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By cartContainerLocator = By.id("shoppingCart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);

    }

    public SearchBox searchBox()
    {
        return this.searchBox;
    }


    public void goToCart()
    {
        click(cartContainerLocator);
    }
}
