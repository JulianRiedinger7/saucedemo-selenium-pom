package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class OverviewPage extends BasePage {

    @FindBy(className = "title")
    private WebElement mainTitle;

    @FindBy(className = "cart_item")
    private List<WebElement> overviewItemsList;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public int getOverviewItemsListSize() {
        super.waitElementsVisibility(overviewItemsList);
        return overviewItemsList.size();
    }

    public CompletionPage finishBuy() {
        super.waitToBeClickable(finishBtn);
        finishBtn.click();

        return new CompletionPage(driver);
    }
}
