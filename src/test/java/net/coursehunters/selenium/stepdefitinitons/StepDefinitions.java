package net.coursehunters.selenium.stepdefitinitons;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.coursehunters.selenium.base.BaseTest;
import net.coursehunters.selenium.pages.HomePage;
import net.coursehunters.selenium.pages.MyAccountPage;
import net.coursehunters.selenium.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    MyAccountPage myAccountPage;



    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }



    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage = new HomePage(driver);
    }

    @When("I click on signIn button")
    public void i_click_on_signIn_button() {
        signInPage = homePage.pushSignIn();
    }

    @Then("SignIn page is opened")
    public void signin_page_is_opened() {
        String expectedPageTitle = "Login - My Store";
        String actualPageTitle = signInPage.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle,"Title is incorrect!!!!!!!!!!!!!!!");
    }

    @When("I enter correct email and password into signIn form")
    public void i_enter_correct_email_into_the_signIn_email_field() {
        signInPage.fillSignInForm("test_a1@test.com", "test_a1");
    }


    @When("I click on green signIn button")
    public void i_click_on_green_signIn_button() {
        myAccountPage = signInPage.pushSignInButton();
    }

    @Then("I'm logged in")
    public void i_m_logged_in() {
        String expectedSignedInAccount = "Petro Kozylets";
        String actualSignedInAccount = myAccountPage.getAccountName();
        Assert.assertEquals(expectedSignedInAccount, actualSignedInAccount,"Signed in account is incorrect!!!!!!!!!!!!!!!");
    }

    @When("I enter \"([^\"]*)\" and \"([^\"]*)\" into signIn form")
    public void i_enter_correct_and_into_signIn_form(String email, String password) {
        signInPage.fillSignInForm(email, password);

    }

    @Then("Error \"([^\"]*)\" is displayed")
    public void error_is_displayed(String message) {
        String actualErrorMessage = signInPage.getSignErrorMessage();
        Assert.assertEquals(actualErrorMessage,message);
    }



}
