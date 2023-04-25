package utilities;

import browserfactory.BaseTest;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will send Text to element
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    //This method will get text from element
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }
    //Select class method
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
