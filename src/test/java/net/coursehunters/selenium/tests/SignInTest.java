package net.coursehunters.selenium.tests;

import net.coursehunters.selenium.base.BaseTest;
import net.coursehunters.selenium.pages.HomePage;
import net.coursehunters.selenium.pages.MyAccountPage;
import net.coursehunters.selenium.pages.SignInPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Collection;

public class SignInTest extends BaseTest{

    @Test
    @DisplayName("Positive LogIn")
    public void testSuccessfulSignIn(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage =  homePage.pushSignIn().waitSignInPageToLoad();
        signInPage.fillSignInForm("test_a1@test.com", "test_a1");
        MyAccountPage myAccountPage = signInPage.pushSignInButton().waitMyAccountPageToLoad();

        String expectedPageTitle = "My account - My Store";
        String actualPageTitle = myAccountPage.getTitle();
        Assertions.assertEquals("Title is incorrect!!!!!!!!!!!!!!!", expectedPageTitle, actualPageTitle);

        String expectedSignedInAccount = "Petro Kozylets";
        String actualSignedInAccount = myAccountPage.getAccountName();
        Assertions.assertEquals(expectedSignedInAccount, actualSignedInAccount,"Signed in account is incorrect!!!!!!!!!!!!!!!");
    }

    @DisplayName("Negative LogIn")
    @ParameterizedTest(name = "Negative LogIn: {2}")
    @CsvSource({
            "test_a1error@test.com,    test_a11111,   Authentication failed.",
            "test_a1error@test.com,              1,   Invalid password.",
            "                   '',            213,   An email address required.",
            "test_a1error@test.com,             '',   Password is required."
    })
    public void testUnSuccessfulSignIn(String email, String password, String errorMessage){
        SignInPage signInPage =  new HomePage(driver)
                .pushSignIn()
                .waitSignInPageToLoad();

        signInPage.fillSignInForm(email, password);
        signInPage.pushSignInButton();
        String actualErrorMessage = signInPage.getSignErrorMessage();
        Assertions.assertEquals(errorMessage,actualErrorMessage);
    }
}
