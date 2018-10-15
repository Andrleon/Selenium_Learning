package net.coursehunters.selenium.pages;

import net.coursehunters.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject<HomePage> {
    public HomePage(WebDriver driver) {
        super(driver);
        openHomePage();
    }

    private static final String URL = "http://automationpractice.com/index.php";
    private By signInButton = By.className("login");

   public void openHomePage(){
        getPage(URL);
    }

    public SignInPage pushSignIn(){
        click(signInButton);
        return new SignInPage(driver);
    }


}
