package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsssertionLearning {
    WebDriver driver;


    @Test
    public void Example_AssertTrue()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed());
        Assert.assertEquals(driver.getTitle(),"Google");


        driver.quit();
        System.out.println("Google Application Closed Successfully");
    }

}
