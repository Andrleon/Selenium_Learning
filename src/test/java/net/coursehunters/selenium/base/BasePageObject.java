package net.coursehunters.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
    protected WebDriver driver;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }

    protected void write(String text, By element) {
        find(element).sendKeys(text);
    }

    protected void clear(By element) {
        find(element).clear();
    }

    protected void click(By element) {
        find(element).click();
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getText(By element) {
        return find(element).getText();
    }


    protected void waitForVisibilityOf(By locator, Integer timeout) {
        int attempt = 0;
        while (attempt < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), 10);
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempt++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }


}