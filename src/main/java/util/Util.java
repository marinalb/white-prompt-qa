package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    public static String returnValue(String property){
        String returnProperty = null;

        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("src/main/java/conf.properties"));
            returnProperty = properties.getProperty(property);
        } catch (IOException e){
            e.printStackTrace();
        }
        return returnProperty;
    }

    public static WebDriver returnBrowser(String browser) {
        WebDriver driver = null;

        if (getOperatingSystem().contains("Windows")){
            System.setProperty("webdriver.chrome.driver", returnValue("driver.chrome"));
            driver = new ChromeDriver();
        } else if (getOperatingSystem().contains("mac")){
            System.setProperty("webdriver.chrome.driver", returnValue("driver.chrome.mac"));
            driver = new ChromeDriver();

        }
        return driver;
    }

    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("System: " + os);
        return os;
    }
}
