package configurations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public static WebDriver driver;

//Будет вызываться каждый раз перед выполнением команды
    @BeforeClass
    public static void createDriver() {
        driver = DriverConfig.create(BROWSERS.CHROMEINCOGNITO); // змінюємо тут завюди браузер, який нам потрібен
      //  driver = DriverConfig.create(BROWSERS.CHROMEWITHPROXY);
    }

    //Будет вызываться каждый раз после выполнения команды
    @AfterClass
    public static void after() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}