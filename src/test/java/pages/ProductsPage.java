package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(className = "title")
    private WebElement mainTitle;

    @FindBy(css = ".pricebar button")
    private List<WebElement> addToCartBtnList;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleCorrect(String title) {
        waitElementVisibility(mainTitle);
        return mainTitle.isDisplayed() && mainTitle.getText().equalsIgnoreCase(title);
    }

    public void addProduct(int index) {
        try {
            WebElement addBtn = addToCartBtnList.get(index);
            super.waitToBeClickable(addBtn);
            addBtn.click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Product does not exist " + e.getMessage());
        }
    }

    public CartPage goToCart() {
        super.waitToBeClickable(cartIcon);
        cartIcon.click();

        return new CartPage(driver);
    }

    public CartPage addAProductAndGoToCart(int index) {
        try {
            WebElement addBtn = addToCartBtnList.get(index);
            super.waitToBeClickable(addBtn);
            addBtn.click();

            super.waitToBeClickable(cartIcon);
            cartIcon.click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Product does not exist " + e.getMessage());
        }

        return new CartPage(driver);
    }

    public LoginPage logout() {
        super.waitToBeClickable(hamburgerBtn);
        hamburgerBtn.click();

        super.waitToBeClickable(logoutBtn);
        logoutBtn.click();


        return new LoginPage(driver);
    }
}
