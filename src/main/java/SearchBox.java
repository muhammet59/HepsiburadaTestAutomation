import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.xpath("//*[@class=\"searchBoxOld-M1esqHPyWSuRUjMCALPK\"]");
    By searchBoxEnteryLocator = By.xpath("//*[@class=\"theme-IYtZzqYPto8PhOx3ku3c theme-JOTHTAYrQhCBEf9bVgI8\"]");
    By submitButtonLocator = new By.ByCssSelector(".searchBoxOld-yDJzsIfi_S5gVgoapx6f");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String productName){
        click(searchBoxLocator);
        waitForElementVisibility(searchBoxEnteryLocator);
        write(searchBoxEnteryLocator, productName);
        click(submitButtonLocator);
    }
}
