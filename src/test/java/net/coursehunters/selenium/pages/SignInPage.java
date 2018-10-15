package net.coursehunters.selenium.pages;

import net.coursehunters.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePageObject<SignInPage> {
    protected SignInPage(WebDriver driver) {
        super(driver);
    }

    private By newAccountEmailField = By.id("email_create");
    private By signInEmailField = By.id("email");
    private By signInPasswordField = By.id("passwd");
    private By submitSignInButton = By.id("SubmitLogin");
    private By signInErrorMessage  = By.xpath("//div[@class='alert alert-danger']/ol/li");

    public void fillSignInForm(String email, String password) {
        write(email, signInEmailField);
        write(password, signInPasswordField);
    }

    public void clearSignInForm() {
        clear(signInEmailField);
        clear(signInPasswordField);
    }


    public MyAccountPage pushSignInButton() {
        click(submitSignInButton);
        return new MyAccountPage(driver);
    }

    public SignInPage waitSignInPageToLoad() {
        waitForVisibilityOf(submitSignInButton, 10);
        waitForVisibilityOf(newAccountEmailField, 10);
        return this;
    }


    public String getSignErrorMessage() {
        return getText(signInErrorMessage);
    }

}
