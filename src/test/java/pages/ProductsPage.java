package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(className = "inventory-item")
    private List<WebElement> productsList;

    @FindBy(css = ".pricebar button")
    private List<WebElement> addToCartBtnList;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public int getProductsListSize() {
        super.waitElementsVisibility(productsList);
        return productsList.size();
    }

    public CartPage addAProduct(int index) {
        super.waitElementsVisibility(productsList);

        try {
            WebElement addBtn = addToCartBtnList.get(index);
            super.waitToBeClickable(addBtn);
            addBtn.click();

            super.waitToBeClickable(cartIcon);
            cartIcon.click();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Product does not exist" + e.getMessage());
        }

        return new CartPage(driver);
    }
}
