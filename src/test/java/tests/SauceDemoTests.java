package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class SauceDemoTests extends BaseTest {

    LoginPage loginPage;
    ProductsPage products;
    CartPage cart;

    @Test
    @Parameters({"username", "password"})
    public void successfulLoginTest(String username, String password) {
        loginPage = loadFirstPage();

        products = loginPage.login(username, password);

        Assert.assertTrue(products.isTitleCorrect("Products"), "The title does not match");
    }

    @Test(dependsOnMethods = "successfulLoginTest")
    @Parameters({"firstName", "lastName", "postalCode"})
    public void buyRandomProductTest(String firstName, String lastName, String postalCode) {
        cart = products.addAProductAndGoToCart(0);

        Assert.assertTrue(cart.isTitleCorrect("Your Cart"), "The title does not match");
        Assert.assertEquals(cart.getCartItemsListSize(), 1, "The cart size does not match");

        InformationPage information = cart.checkout();

        Assert.assertTrue(information.isTitleCorrect("Checkout: Your Information"), "The titles does not match");

        OverviewPage overview = information.completeInformation(firstName, lastName, postalCode);

        Assert.assertTrue(overview.isTitleCorrect("Checkout: Overview"), "The titles does not match");
        Assert.assertEquals(overview.getOverviewItemsListSize(), 1, "The overview items size does not match");

        CompletionPage completion = overview.finishBuy();

        Assert.assertTrue(completion.isTitleCorrect("Thank you for your order!"), "The titles does not match");

        products = completion.goHome();

        Assert.assertTrue(products.isTitleCorrect("Products"), "The titles does not match");
    }

    @Test(dependsOnMethods = "successfulLoginTest")
    public void addAndRemoveThreeProductsTest() {
        products.addProduct(0);
        products.addProduct(1);
        products.addProduct(2);

        cart = products.goToCart();

        Assert.assertTrue(cart.isTitleCorrect("Your cart"), "The titles does not match");
        Assert.assertEquals(cart.getCartItemsListSize(), 3, "The cart size does not match");

        cart.clearCart();

        Assert.assertTrue(cart.isItemsListEmpty());

        products = cart.continueShopping();
    }

    @Test(dependsOnMethods = "successfulLoginTest")
    public void logoutTest() {
        loginPage = products.logout();

        Assert.assertTrue(loginPage.areInputsVisible(), "The inputs are not visible");
    }

}
