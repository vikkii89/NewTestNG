package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Infyni {
    WebDriver driver;

/*

    @Given("user launch Infyni application with URL as {string}")
    public void user_launch_infyni_application_with_url_as(String string) {

        System.out.println("############ STARTING INFYNI###################");
        System.out.println("############ DATE : 27 June 2023 ###################");

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

    }


    @Then("user navigate to signup page")
    public void user_navigate_to_signup_page() {

         driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
         driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

    }
    @Then("user see Header as All fields are mandatory")
    public void user_see_header_as_all_fields_are_mandatory() {
        driver.findElement(By.xpath("//span[contains(.,'All fields are mandatory')]")).isDisplayed();

    }
    @Then("user fill First Name as {string}")
    public void user_fill_first_name_as(String string) {
        driver.findElement(By.id("first_name")).sendKeys(string);


    }
    @Then("user fill Last Name as {string}")
    public void user_fill_last_name_as(String string) {
        driver.findElement(By.id("last_name")).sendKeys(string);


    }
    @Then("user fill email address as {string}")
    public void user_fill_email_address_as(String string) {
        driver.findElement(By.id("email")).sendKeys(string);


    }
    @Then("user fill password as {string}")
    public void user_fill_password_as(String string) {
        driver.findElement(By.id("id_password")).sendKeys(string);

    }
    @Then("user fill confirm password as {string}")
    public void user_fill_confirm_password_as(String string) {
        driver.findElement(By.id("id_confirm_password")).sendKeys(string);


        driver.quit();

    }  */




    // Dated on 07/06/2023


    @Given("user launch Infyni Website  {string}")
    public void user_launch_infyni_website(String string) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\dhana\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.infyni.com");
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));



    }

    @Then("user validate Infyni logo")
    public void user_validate_infyni_logo() {

        driver.findElement(By.xpath("//img[@alt='infyni']")).isDisplayed();

    }

    @When("user click on LogIn button")
    public void user_click_on_log_in_button() {

        driver.findElement(By.xpath("//a[text()='Login']")).click();

    }

    @Then("user navigate to LogIn page")
    public void user_navigate_to_log_in_page() {
       driver.findElement(By.xpath("//h2[text()='Log in to your Account']")).isDisplayed();
    }

    @Then("Validate remember me check box is not checked by default")
    public void validate_remember_me_check_box_is_not_checked_by_default() {

        Assert.assertTrue(!driver.findElement(By.xpath("//input[@name='RememberMe']")).isSelected());

    }

    @Then("user input incorrect {string} and {string}")
    public void user_input_incorrect_and(String userID, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userID);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        // driver.findElement(By.xpath("//button[text()='Sign In']")).click();

        WebElement element = driver.findElement(By.xpath("//button[text()='Sign In']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }

    @Then("user see error message  says invalid credentials")
    public void user_see_error_message_says_invalid_credentials() {
       driver.findElement(By.xpath("//div[@class='error btns']")).isDisplayed();
    }

    @Then("user clicks on Dont have a account SignUp link")
    public void user_clicks_on_dont_have_a_account_sign_up_link() {
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();


    }

    @Then("user successfully navigated to signUp page")
    public void user_successfully_navigated_to_sign_up_page() {
        driver.findElement(By.xpath("//span[contains(.,'All fields are mandatory')]")).isDisplayed();


        driver.quit();
    }



}
