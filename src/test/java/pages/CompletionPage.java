package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class CompletionPage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement mainTitle;

    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;

    public CompletionPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage goHome() {
        super.waitToBeClickable(backHomeBtn);
        backHomeBtn.click();

        return new ProductsPage(driver);
    }
}
