package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    public static String retornaValor(String propriedade){
        String retorno = null;

        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("src/main/java/conf.properties"));
            retorno = properties.getProperty(propriedade);
        } catch (IOException e){
            e.printStackTrace();
        }
        return retorno;
    }

    public static WebDriver retornaBrowser(String browser) throws Exception {
        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", retornaValor("driver.chrome"));
        driver = new ChromeDriver();

        return driver;
    }

    public static String getOperatingSystem() {
        String os = System.getProperty("os.name");
        System.out.println("System: " + os);
        return os;
    }



}
