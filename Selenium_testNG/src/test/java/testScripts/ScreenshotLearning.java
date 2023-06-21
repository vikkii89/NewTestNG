package testScripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ScreenshotLearning {

    private WebDriver driver;
    String Screenshotpath = "C:\\workspace\\javaProjects\\seleniumInfyni\\Selenium_testNG\\test-output\\Screenshot";


    @BeforeClass
    public void setup() {


        System.out.println("##### Starting Chrome Browser ############");


//ChromeOptions opt = new ChromeOptions();
//opt.addArguments("--remote-allow-origins=*");
//WebDriverManager.chromedriver().setup();


        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.docker.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }


    @Test
    public void Capture_Screenshot_during_fail() {
        try {
            driver.findElement(By.xpath("//abcd")).click();


        } catch (Exception e) {
            Capture_Screenshot("Docker_Logo");
        }
    }


    public void Capture_Screenshot(String Screenshotname) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(Screenshotpath + "/" + Screenshotname + ".png"));


        } catch (Exception e) {
        }
    }


    //We are validating select functionality to select a dropdown
    @Test
    public void validate_Select_Functionality() {
        try {
            driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));


            if (driver.findElement(By.xpath("//select[@id='dropdown']")).isDisplayed()) {


                Select drop_down = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
// select dropdown by the text which is available in the options
                drop_down.selectByVisibleText("Option 2");
                Thread.sleep(3000);
// selecting dropdown using index
                drop_down.selectByIndex(1);
                Thread.sleep(3000);
                drop_down.selectByValue("2");
                Thread.sleep(3000);


            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @AfterClass
    public void quit_the_session() {
        driver.quit();

    }

}
