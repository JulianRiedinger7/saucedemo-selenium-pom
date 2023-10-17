package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement mainTitle;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItemsList;

    @FindBy(css = ".cart_item button")
    private List<WebElement> removeBtnList;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsListSize() {
        super.waitElementsVisibility(cartItemsList);
        return cartItemsList.size();
    }

    public boolean isTitleCorrect(String title) {
        waitElementVisibility(mainTitle);
        return mainTitle.isDisplayed() && mainTitle.getText().equalsIgnoreCase(title);
    }

    public boolean isItemsListEmpty() {
        return cartItemsList.isEmpty();
    }

    public void clearCart() {
        for (WebElement removeBtn : removeBtnList) {
            waitToBeClickable(removeBtn);
            removeBtn.click();
        }
    }

    public InformationPage checkout() {
        super.waitToBeClickable(checkoutBtn);
        checkoutBtn.click();
        return new InformationPage(driver);
    }

    public ProductsPage continueShopping() {
        super.waitToBeClickable(continueShoppingBtn);
        continueShoppingBtn.click();

        return new ProductsPage(driver);
    }

}
