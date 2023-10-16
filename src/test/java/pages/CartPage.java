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

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemsListSize() {
        super.waitElementsVisibility(cartItemsList);
        return cartItemsList.size();
    }

    public InformationPage checkout() {
        super.waitToBeClickable(checkoutBtn);
        checkoutBtn.click();
        return new InformationPage(driver);
    }
}
