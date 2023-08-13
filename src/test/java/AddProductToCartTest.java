import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddProductToCartTest extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    ProductsDetailPage productsDetailPage;
    CartPage cartPage;
    SearchBox searchBox;

    @Test
    @Order(1)
    public void search_product() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Kalem");
        Assertions.assertTrue(productsPage.isOnProductsPage(), "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_product() {
        productsDetailPage = new ProductsDetailPage(driver);
        productsPage.selectProduct(1);
        Assertions.assertTrue(productsDetailPage.isOnProductDetailPage(), "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void select_newest_review() {
        productsDetailPage.selectNewestReview();
        Assertions.assertTrue(productsDetailPage.isOnSortNewestReview(), "Sort newest revies not selected!");
    }

    @Test
    @Order(4)
    public void like_the_review() {
        productsDetailPage.clickTheLikeCommentButton();
        Assertions.assertTrue(productsDetailPage.isReviewFeedbackSeen(), "Review feedback not seen!");
    }

    @Test
    @Order(5)
    public void add_product_to_cart() {
        cartPage = new CartPage(driver);
        productsDetailPage.addProductToCart();
        homePage.goToCart();
        Assertions.assertTrue(cartPage.isOnCartPage(),"Not on cart page!");
        Assertions.assertTrue(cartPage.isProductAdded(), "Product wasn't added to cart");

    }
}
