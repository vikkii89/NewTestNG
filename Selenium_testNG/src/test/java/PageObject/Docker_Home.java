package PageObject;

import org.openqa.selenium.By;

public class Docker_Home {

    public By SignIn_Link(){
        return By.xpath("(//a[text()='Sign In'])[1]");
    }

    public By Logo_Link(){
        return By.xpath("//li[@class='logo']");
    }
}
