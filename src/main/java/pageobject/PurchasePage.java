package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchasePage {
    private final WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inventory_container")));
    }

        public void clickAddCart(){
            for (int i=1;i<7;i++){
            driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child("+ i +") > div.pricebar > button")).click();
        }
    }

    public void clickCartButton(){
            driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).click();
    }

    public void clickCheckoutButton(){
        driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button")).click();
    }

    public Boolean addCart(){
        clickAddCart();
        clickCartButton();
        clickCheckoutButton();
        return true;

    }
}
