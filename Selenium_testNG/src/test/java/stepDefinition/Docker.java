package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Docker {

    WebDriver driver;

    @Given("user launch Docker website with URL as {string}")
    public void user_launch_docker_website_with_url_as(String string) {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

    }


    @Then("user validate Docker logo")
    public void user_validate_docker_logo() {

        driver.findElement(By.className("logo")).isDisplayed();

    }
    @Then("user validate signIn link")
    public void user_validate_sign_in_link() {

        driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).isDisplayed();

    }
    @Then("user validate Get Started link")
    public void user_validate_get_started_link() {

        driver.findElement(By.className("header_button")).isDisplayed();

    }
    @Then("user validate the Products dropdown by Hovering it")
    public void user_validate_the_products_dropdown_by_hovering_it() {

        // mouse hovering
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//a[text()='Products'])[1]"));
        builder.moveToElement(element).build().perform();

    }
    @Then("user scroll down to bottom of the page and validate {string}")
    public void user_scroll_down_to_bottom_of_the_page_and_validate(String string) {

        WebElement element = driver.findElement(By.xpath("//h2[text()='Accelerate your application development today.']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }
    @Then("user validate all the social media links")
    public void user_validate_all_the_social_media_links() {

        driver.findElement(By.xpath("//img[@alt='facebook logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='twitter logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='youtube logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='linkedin logo']")).isDisplayed();
        driver.findElement(By.xpath("//img[@alt='rss feed logo']")).isDisplayed();


    }

    @After
    public void teardown(){
        driver.quit();

    }

}
