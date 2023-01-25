import configurations.BaseClass;
import data.DataProviders;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static org.testng.Assert.*;

public class TestWiki extends BaseClass {

    @BeforeClass
    public void startTest() {
        driver.get("https://wikipedia.org/");
    }

    @Test(description = "this test check title", groups = {"smoke", "regressions"}, priority = 2)
    public void test1() {
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(),"new Title");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("test2");
    }

    @Test(description = "*******", groups = {"smoke"}, dependsOnMethods = "test1", alwaysRun = true, priority = 1)
    public void test3() {
        System.out.println("test3");
    }

    @Test(description = "dataprov", groups = {"all"}, dataProviderClass = DataProviders.class, dataProvider = "dateLang")
    public void test4(String lang) throws InterruptedException {
        ResourceBundle bundle = ResourceBundle.getBundle(lang);
        driver.get("https://" + bundle.getString("lang") + ".wikipedia.org/");
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterTest() {
        driver.close();
    }
}