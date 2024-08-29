package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity1 {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedTitle = "Alchemy Jobs – Job Board Application";
        String originalTitle = driver.getTitle();
        System.out.println("Original Title :" + originalTitle);
        try {
            Assert.assertEquals(originalTitle, expectedTitle);
            System.out.println("Original Title :" + originalTitle + "  --match with Expected Title :" + expectedTitle);
        } catch (Exception e) {
            System.out.println("Original Title :" + originalTitle + "  --Does not match with Expected Title :" + expectedTitle);
        }

        driver.quit();
    }
}
