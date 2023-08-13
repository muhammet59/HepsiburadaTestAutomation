package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpHandler {
    private WebDriver driver;

    By acceptButtonLocator = By.id("onetrust-accept-btn-handler");

    public PopUpHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopUpIfExists() {
        try {
            WebElement element = driver.findElement(acceptButtonLocator);
            if (element.isDisplayed()) {
                System.out.println("Pop-up seen");
                element.click();
                System.out.println("Pop-up accepted");
            } else {
                System.out.println("Pop-up not seen");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Pop-up element");
        }
    }

}

