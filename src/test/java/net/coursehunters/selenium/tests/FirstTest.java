package net.coursehunters.selenium.tests;

import net.coursehunters.selenium.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void testRegisterNewUser() {
        driver.get("http://automationpractice.com/index.php");                                 // +
        driver.findElement(By.className("login")).click();                                     // +
        driver.findElement(By.id("email_create")).sendKeys("test_a1@test.com");
        driver.findElement(By.name("SubmitCreate")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Petro");
        driver.findElement(By.id("customer_lastname")).sendKeys("Kozylets");
        driver.findElement(By.id("passwd")).sendKeys("test_a1");
        WebElement tempElement = driver.findElement(By.id("days"));
        tempElement.click();
        tempElement.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        tempElement = driver.findElement(By.id("months"));
        tempElement.click();
        tempElement.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        tempElement = driver.findElement(By.id("years"));
        tempElement.click();
        tempElement.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        driver.findElement(By.id("firstname")).sendKeys("Petro");
        driver.findElement(By.id("lastname")).sendKeys("Kozylets");
        driver.findElement(By.id("address1")).sendKeys("qweqwe123123");
        driver.findElement(By.id("city")).sendKeys("qweqwe123123");
        tempElement = driver.findElement(By.id("id_state"));
        tempElement.click();
        tempElement.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        driver.findElement(By.id("postcode")).sendKeys("qweqwe123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        wait.until(ExpectedConditions.titleContains("Login"));

    }


}
