package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
    }

    public void findUser(String user){
        driver.findElement(By.id("user-name")).sendKeys(user);
        //TakeSnapShot.takeSnapShot(driver, this.getClass().getName());
    }

    public void findPass(String password){
        driver.findElement(By.id("password")).sendKeys(password);
        //TakeSnapShot.takeSnapShot(driver, this.getClass().getName());
    }

    public void clickAccess(){
        driver.findElement(By.cssSelector("#login_button_container > div > form > input.btn_action")).click();
    }

    public Boolean loginAccess(String user, String password){
        findUser(user);
        findPass(password);
        clickAccess();
       // TakeSnapShot.takeSnapShot(driver, this.getClass().getName());

        return true;

    }


}
