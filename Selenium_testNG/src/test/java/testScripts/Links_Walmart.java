package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.Support;

import java.time.Duration;

public class Links_Walmart {
    public WebDriver driver;
    public Support obj;

    @BeforeClass
    public void first_step() throws Exception{
        obj = new Support();
        // iniialization of chrome driveR class

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        // launch browser
        // driver.get(obj.read_properties_file("amazon_url"));
        driver.get("https://www.walmart.com");

        // maximize the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

    }

    @Test
    public void print_all_links() {
        try {
            int link_count= driver.findElements(By.xpath("//a")).size();
            for(int i=1;i<link_count;i++)
            {
                String link=driver.findElement(By.xpath("(//a)["+i+"]")).getText();
                String href=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("href");
                String innerHTML=driver.findElement(By.xpath("(//a)["+i+"]")).getAttribute("innerHTML");
                System.out.println("The link name is==>"+innerHTML);
            }
        } catch (Exception e)
        {
        }

    }

    @AfterClass
    public void quit_the_session() {
        driver.quit();
    }



}

