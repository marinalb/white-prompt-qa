package ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.CheckoutPage;
import pageobject.LoginPage;
import pageobject.OverviewPage;
import pageobject.PurchasePage;
import util.Util;

public class LoginAndPurchaseTest {
    private WebDriver driver;

    @BeforeTest
    public void preCondition() {
        driver = Util.returnBrowser(Util.returnValue(("browser")));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void login(){
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.loginAccess("standard_user", "secret_sauce"), "Login Failed");

        PurchasePage purchase = new PurchasePage(driver);
        Assert.assertNotNull(purchase.addCart());

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.checkout();

        OverviewPage overview = new OverviewPage(driver);
        overview.clickFinishButton();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
