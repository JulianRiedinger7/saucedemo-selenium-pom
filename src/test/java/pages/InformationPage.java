package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class InformationPage extends BasePage {

    @FindBy(className = "title")
    private WebElement mainTitle;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage completeInformation(String firstName, String lastName, String postalCode) {
        super.waitElementVisibility(firstNameInput);
        firstNameInput.sendKeys(firstName);

        super.waitElementVisibility(lastNameInput);
        lastNameInput.sendKeys(lastName);

        super.waitElementVisibility(postalCodeInput);
        postalCodeInput.sendKeys(postalCode);

        super.waitToBeClickable(continueBtn);
        continueBtn.click();

        return new OverviewPage(driver);
    }
}
