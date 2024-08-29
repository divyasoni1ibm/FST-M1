package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity7 {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement postJob = driver.findElement(By.xpath("//a[contains(text(),'Post a Job')]"));
        postJob.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='create_account_email']"));
        email.sendKeys("swasin21@in.ibm.com");
        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job_title']"));
        jobTitle.sendKeys("Assistant Director");
        WebElement jobLocation = driver.findElement(By.xpath("//input[@id='job_location']"));
        jobLocation.sendKeys("India");

        try {
            WebElement description = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
            description.click();;
            description.sendKeys("Test Test Test");
        } catch (Exception e) {
            System.out.println("--------------Description is not entered successfully-----------------");
            driver.switchTo().defaultContent();
        }

        WebElement applicationEmail = driver.findElement(By.xpath("//input[@id='application']"));
        applicationEmail.sendKeys("https://lms.training-support.net/alchemy");
        WebElement companyName = driver.findElement(By.xpath("//input[@id='company_name']"));
        companyName.sendKeys("LMS Training");
        WebElement companyWebsite = driver.findElement(By.xpath("//input[@id='company_website']"));
        companyWebsite.sendKeys("https://lms.training-support.net/alchemy");

        WebElement submitJob = driver.findElement(By.xpath("//input[@name='submit_job']"));
        submitJob.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement submitListings = driver.findElement(By.xpath("//input[@id='job_preview_submit_button']"));
        submitListings.click();

        WebElement validateJobPost = driver.findElement(By.xpath("//div[@class='main-navigation']/ul/li[1]/a"));
        validateJobPost.click();

        driver.close();
    }
}
