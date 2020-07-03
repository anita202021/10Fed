package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.concurrent.TimeUnit;


public class UserSigninPage extends PageObject {

    @FindBy(xpath = "//input[@name='userName']")
    private WebElementFacade userName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElementFacade password;
    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElementFacade signinButton;
    @FindBy(xpath = "//h3[text()=' Dashboard ']")
    private WebElementFacade dashboardTitle;
    @FindBy(xpath = "//span[text()='Sign Out']")
    private WebElementFacade signoutLink;
    @FindBy(xpath = "//div[text()=' Invalid credential. ']")
    private WebElementFacade invalidCredentials;


    private By validationOnLoginScreen(String errorMessage) {
        return By.xpath("//div[contains(text(),'" + errorMessage + "')]");
    }


    public void enterCredentials(String userEmail, String pwd) {
        try {
            userName.sendKeys(userEmail);
            password.sendKeys(pwd);
            withTimeoutOf(20, TimeUnit.SECONDS).waitFor(signinButton).click();
        } catch (Exception ignored) {

        }

    }


    public void verifyHomepage() {
        dashboardTitle.isVisible();
    }

    public void signout() {
        waitABit(1000);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(signoutLink).click();
    }

    public void errorForInvalidCredentials() {
        waitFor(invalidCredentials).withTimeoutOf(20, TimeUnit.SECONDS).isDisplayed();
    }

    public void validationMessage(String err) {
        element(validationOnLoginScreen(err)).withTimeoutOf(20, TimeUnit.SECONDS).isDisplayed();
    }
}

