package net.coursehunters.selenium.pages;

import net.coursehunters.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePageObject<MyAccountPage> {
    protected MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private By accountLinkList = By.className("myaccount-link-list");
    private By accountName = By.xpath("//div[@class='header_user_info']/a[@class ='account']");

    public MyAccountPage waitMyAccountPageToLoad() {
        waitForVisibilityOf(accountLinkList, 10);
        return this;
    }

    public String getAccountName() {
        return getText(accountName);
    }
}
