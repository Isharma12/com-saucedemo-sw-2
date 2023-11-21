package testsuite;
/**
 * Write down the following test into ‘LoginTest’ class 1. userSholdLoginSuccessfullyWithValid Credentials * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on  page 
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
     public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter the username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter the Password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on Login button
        driver.findElement(By.name("login-button")).click();
        //Verify the text products
        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
@Test
public void verifyThatSixProductsAreDisplayOnPage() {
    //Enter the username
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    //Enter the Password
    driver.findElement(By.name("password")).sendKeys("secret_sauce");
    //Click on Login button
    driver.findElement(By.name("login-button")).click();
    //Verify the text products


    List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
    int actual = products.size();
    int expected = 6;
    Assert.assertEquals("Correct Amount not Displayed",expected,actual);
}
    @After
    public void tearDown () {
        closeBrowser();
    }
}
