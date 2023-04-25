package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String basUrl = "https://www.saucedemo.com/";
    @Before
    public void setup(){
        openBrowser(basUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        //Enter UserName
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter Password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on Login Button
        clickOnElement(By.id("login-button"));
        //Verify the text Products
        String expectedMassage = "Products";
        String actualMassage = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        //checking actual and expectedMassage
        Assert.assertEquals(expectedMassage,actualMassage);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter UserName
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter Password
        sendTextToElement(By.id("password"),"secret_sauce");
        //Click on Login Button
        clickOnElement(By.id("login-button"));
        //Verify that six products are displayed on page
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualnumber = number.size();
        int expectednumber = 6;
        Assert.assertEquals("6 product not displayed", expectednumber, actualnumber);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
