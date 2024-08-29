package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement jobs = driver.findElement(By.xpath("//a[normalize-space()='Jobs']"));
        jobs.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String expectedTitle = "Jobs – Alchemy Jobs";
        String jobPageTitle = driver.getTitle();
        System.out.println("Original Job Page Title :" + jobPageTitle);

        try {
            Assert.assertEquals(jobPageTitle, expectedTitle);
            System.out.println("Original Title :" + jobPageTitle + "  --match with Expected Title :" + expectedTitle);
        } catch (Exception e) {
            System.out.println("Original Title :" + jobPageTitle + "  --Does not match with Expected Title :" + expectedTitle);
        }
        driver.close();
    }
}
