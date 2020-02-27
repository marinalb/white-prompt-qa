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
    public void preCondition() throws Exception{
        driver = Util.returnBrowser(Util.returnValue(("browser")));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void posCondition(){
        driver.quit();
    }

    @Test
    public void login(){
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.loginAccess("standard_user", "secret_sauce"), "Login Failed");

        PurchasePage purchase = new PurchasePage(driver);
        purchase.addCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.checkout();

        OverviewPage overview = new OverviewPage(driver);
        overview.clickFinishButton();

    }
}
