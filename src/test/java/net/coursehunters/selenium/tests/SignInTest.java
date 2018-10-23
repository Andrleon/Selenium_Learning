package net.coursehunters.selenium.tests;

import net.coursehunters.selenium.base.BaseTest;
import net.coursehunters.selenium.pages.HomePage;
import net.coursehunters.selenium.pages.MyAccountPage;
import net.coursehunters.selenium.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

public class SignInTest extends BaseTest{

    @Test(groups = {"positive"})
    public void testSuccessfulSignIn(){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage =  homePage.pushSignIn().waitSignInPageToLoad();
        signInPage.fillSignInForm("test_a1@test.com", "test_a1");
        MyAccountPage myAccountPage = signInPage.pushSignInButton().waitMyAccountPageToLoad();

        String expectedPageTitle = "My account - My Store";
        String actualPageTitle = myAccountPage.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle,"Title is incorrect!!!!!!!!!!!!!!!");

        String expectedSignedInAccount = "Petro Kozylets";
        String actualSignedInAccount = myAccountPage.getAccountName();
        Assert.assertEquals(expectedSignedInAccount, actualSignedInAccount,"Signed in account is incorrect!!!!!!!!!!!!!!!");
    }

    @DataProvider(name = "dp")
    public static Object[][] TestData(){
        return new String[][]{
        {"test_a1error@test.com", "test_a11111", "Authentication failed."},
        {"test_a1error@test.com", "1", "Invalid password."},
        {"", "123", "An email address required."},
        {"test_a1error@test.com", "", "Password is required."}};
}


    @Test(dataProvider = "dp", groups = "negative")
    public void testUnSuccessfulSignIn(String email, String password, String errorMessage){
        SignInPage signInPage =  new HomePage(driver)
                .pushSignIn()
                .waitSignInPageToLoad();

        signInPage.fillSignInForm(email, password);
        signInPage.pushSignInButton();
        String actualErrorMessage = signInPage.getSignErrorMessage();
        Assert.assertEquals(actualErrorMessage,errorMessage);
    }

}
