package net.coursehunters.selenium.tests;

import net.coursehunters.selenium.base.BaseTest;
import net.coursehunters.selenium.pages.HomePage;
import net.coursehunters.selenium.pages.SignInPage;
import org.junit.Test;

public class CreateNewAccountTest extends BaseTest {



    @Test
    public void testSuccessfulAccountCreation() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        SignInPage signInPage = homePage.pushSignIn();
    }

}
