import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By cartTextLocator = By.xpath("//*[@class=\"basket_headerTop_F06D4\"]");
    By productNameLocator = By.xpath("//*[@class=\"basket_items_3C53o\"]");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage()
    {
        waitForElementVisibility(cartTextLocator);
        return isDisplayed(cartTextLocator);
    }

    public boolean isProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts()
    {
        return findAll(productNameLocator);
    }
}
