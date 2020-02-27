package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

public class CheckoutPage {
    private final WebDriver driver;
    Faker faker = new Faker();

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("first-name")));
    }

    public void inputFirstUserName(){
        String user = faker.name().firstName();
        driver.findElement(By.id("first-name")).sendKeys(user);
    }

    public void inputLastUserName(){
        String user = faker.name().lastName();
        driver.findElement(By.id("last-name")).sendKeys(user);
    }

    public void inputZipCode(){
        String zipCode = faker.address().zipCode();
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
    }

    public void clickContinueButton(){
        driver.findElement(By.cssSelector("#checkout_info_container > div > form > div.checkout_buttons > input")).click();
    }

    public Boolean checkout(){
        inputFirstUserName();
        inputLastUserName();
        inputZipCode();
        clickContinueButton();
        return true;

    }

}
