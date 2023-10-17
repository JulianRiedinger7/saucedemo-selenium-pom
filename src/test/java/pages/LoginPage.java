package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean areInputsVisible() {
        super.waitElementVisibility(usernameInput);
        super.waitElementVisibility(passwordInput);

        return usernameInput.isDisplayed() && passwordInput.isDisplayed();
    }

    public ProductsPage login(String username, String password) {
        waitElementVisibility(usernameInput);
        usernameInput.sendKeys(username);

        waitElementVisibility(passwordInput);
        passwordInput.sendKeys(password);

        loginBtn.click();
        return new ProductsPage(driver);
    }
}
