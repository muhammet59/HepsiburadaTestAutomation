package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPopUpHandler {
    private WebDriver driver;

    By closeButtonLocator = By.xpath("//*[@class=\"checkoutui-Modal-iHhyy79iR28NvF33vKJb\"]");

    public CartPopUpHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopUpIfExists() {
        try {
            WebElement element = driver.findElement(closeButtonLocator);
            if (element.isDisplayed()) {
                System.out.println("Cart Pop-up seen");
                element.click();
                System.out.println("Cart Pop-up closed");
            } else {
                System.out.println("Cart Pop-up not seen");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Cart Pop-up element");
        }
    }

}

