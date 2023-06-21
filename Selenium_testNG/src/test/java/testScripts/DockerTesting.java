package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import PageObject.Docker_Home;


public class DockerTesting {

    public WebDriver driver;

    public Docker_Home Home;

    @BeforeClass
    @Parameters({"url"})
    public void setup(String url){
        Home = new Docker_Home();

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
         driver = new ChromeDriver();

        // launch the browser
        driver.get(url);

        // Maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    @Parameters({"username","password"})
    public void docker_logo_validation(String username,String password){

            // validate Docker logo
            if (driver.findElement(Home.Logo_Link()).isDisplayed()){
                System.out.println("Docker logo is displayed=====> PASS");
            }
            if (driver.findElement(Home.SignIn_Link()).isDisplayed()){
                System.out.println("Docker Sign in is displayed=====> PASS");
        }
        System.out.println("username is ===> "+username);
        System.out.println("password is ===> "+password);

        }


    @Test
    public void navigateToDockerProPage(){
        // do mouse Hover on products Header menu link

        try{
            WebElement products = driver.findElement(By.xpath("(//a[text()='Products'])[1]"));

            // creating object of an action class
            Actions act = new Actions(driver);
            act.moveToElement(products).perform();

            // wait for 3 seconds
            Thread.sleep(3000);

            // clicking on docker pro link
            driver.findElement(By.xpath("(//a[text()='Docker Pro'])[1]")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // validate docker Pro header

            if (driver.findElement(By.xpath("(//h1[text()='Docker Pro'])[1]")).isDisplayed()){
                System.out.println("User successfully navigated to Docker Pro Page");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    @Test
    public void docker_SignIn_Validation(){

        // validate Docker sign in
        if (driver.findElement(Home.SignIn_Link()).isDisplayed()){
            System.out.println("Docker Sign in is displayed=====> PASS");
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();


    }



}
