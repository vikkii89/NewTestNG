package stepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Flipkart {

    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;

    WebDriver driver;
    @Given("user generate report using Extent report")
    public void user_generate_report_using_extent_report() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");


        // Create an object of Extent Reports
        extent = new ExtentReports();

        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/flipkart.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Host Name", "flipkart Application");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("User Name", "Test Team");
        spark.config().setDocumentTitle("flipkart  websiteCheckout Application QA ");
        // Name of the report
        spark.config().setReportName("flipkart Checkout Application Using Selenium testNG ");
        // Dark Theme
        spark.config().setTheme(Theme.STANDARD);
        logger = extent.createTest("Validate flipkart Checkout Application Using Selenium testNG");



    }

    @Then("user launch flipkart website with URL as {string}")
    public void user_launch_flipkart_website_with_url_as(String string) {

        System.out.println("##### Starting Chrome Browser ############");


        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");

        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));

    }

    @Then("user validate flipkart logo")
    public void user_validate_flipkart_logo() {

        driver.findElement(By.xpath("//img[@alt='Flipkart']")).isDisplayed();

    }

    @Then("user print all the links in flipkart website")
    public void user_print_all_the_links_in_flipkart_website() {

        try {
            int link_count = driver.findElements(By.xpath("//a")).size();
            for (int i = 1; i < link_count; i++) {

                String link = driver.findElement(By.xpath("(//a)[" + i + "]")).getText();
                String href = driver.findElement(By.xpath("(//a)[" + i + "]")).getAttribute("href");
                String innerHTML = driver.findElement(By.xpath("(//a)[" + i + "]")).getAttribute("innerHTML");
                System.out.println("The link name is==>" + innerHTML);
                logger.info(link);
                logger.info(href);
            }
        } catch (Exception e) {
        }

    }

    @After
    public void teardown(){
        extent.flush();

        driver.quit();

    }


}
