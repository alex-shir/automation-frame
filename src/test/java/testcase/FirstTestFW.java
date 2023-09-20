package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

import java.time.Duration;


public class FirstTestFW extends BaseTest {

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "testdata")
    public static void LoginTest(String username, String password) {
        System.out.println("Start");
        driver.findElement(By.cssSelector(loc.getProperty("signin_link"))).click(); // locators --properties
        driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
        driver.findElement(By.cssSelector(loc.getProperty("nrxt_button"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("pwd_field"))));
        driver.findElement(By.id(loc.getProperty("pwd_field"))).sendKeys(password);
        driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
    }

//    @DataProvider(name = "testdata")
//    public Object[][] tData() {
//        return new
//                Object[][]{
//                {"ght@gmail.com", "testautomation@123"},
//                {"rcv@gmail.com", "testautom@123"},
//                {"ght2@gmail.com", "testautomation@123"},
//                {"rcvtu@gmail.com", "testautom@123"}
//        };
//    }
}
