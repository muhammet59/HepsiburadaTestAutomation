import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By brandSelectorLocator = new By.ByCssSelector("label[for='collapse-markalar']");
    By productNameLocator = new By.ByCssSelector(".moria-ProductCard-aBQpD");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isOnProductsPage() {
        return isDisplayed(brandSelectorLocator);
    }

    public List<WebElement> getAllProducts() {
        waitForElementVisibility(productNameLocator);
        return findAll(productNameLocator);
    }

    public void selectProduct(int i) {
        waitForElementVisibility(productNameLocator);
        getAllProducts().get(i).click();
    }


}
