import Helpers.CartPopUpHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ProductsDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("addToCart");
    By reviewsTabLocator = By.id("reviewsTabTrigger");
    By sortListLocator = By.xpath("//*[@class=\"hermes-Sort-module-Zwr_VRf_e4tZXl5J1PgT\"]");
    By sortNewestReviewLocator = By.xpath("(//*[@class=\"hermes-Sort-module-CWnJiGEufJWS8Y2TMNuF hermes-Sort-module-F5wWWffLEvSW2rQuj0Pm\"][1])");
    By thumbsUpLocator = By.xpath("(//*[@class=\"thumbsUp hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV\"])[1]");
    By reviewFeedbackText = new By.ByCssSelector("div[class='hermes-ReviewCard-module-QA5PqdPP5EhkpY_vptfv'] span[class='hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca']");
    By productDetailsLocator = new By.ByCssSelector(".hermes-ProductRate-module-UEAeElFF8nPIcxewC6P7 > a");
    By closeButtonLocator = By.xpath("//*[@class=\"checkoutui-Modal-iHhyy79iR28NvF33vKJb\"]");


    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        switchToNewWindow(driver);
        waitForElementVisibility(addToCartButtonLocator);
        return isDisplayed(addToCartButtonLocator);
    }

    public void selectNewestReview() {
        scrollToElement(driver, reviewsTabLocator);
        click(reviewsTabLocator);
        click(sortListLocator);
        waitForElementVisibility(sortNewestReviewLocator);
        click(sortNewestReviewLocator);
    }

    public boolean isOnSortNewestReview() {
        scrollToElement(driver, sortListLocator);
        click(sortListLocator);
        return isDisplayed(sortNewestReviewLocator);
    }

    public void clickTheLikeCommentButton()
    {
        scrollToElement(driver, thumbsUpLocator);
        click(thumbsUpLocator);
    }

    public boolean isReviewFeedbackSeen()
    {
        return isDisplayed(reviewFeedbackText);
    }

    public void addProductToCart() {
        scrollToElement(driver, productDetailsLocator);
        click(productDetailsLocator);
        waitForElementVisibility(addToCartButtonLocator);
        click(addToCartButtonLocator);
        waitForElementVisibility(closeButtonLocator);
        CartPopUpHandler popUp = new CartPopUpHandler(driver);
        popUp.closePopUpIfExists();
        click(addToCartButtonLocator);
    }
}
