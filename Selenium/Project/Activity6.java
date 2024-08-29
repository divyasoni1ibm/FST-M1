package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("----Enter Banking Jobs-----");
        WebElement enterJobs = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        enterJobs.sendKeys("Banking");
        Thread.sleep(500);
        System.out.println("----Click Search Banking Jobs-----");
        WebElement searchJobs = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
        searchJobs.click();
        Thread.sleep(500);
        System.out.println("----Click Searched Banking Jobs-----");
        WebElement clickSearchedJobs = driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a"));
        clickSearchedJobs.click();
        Thread.sleep(500);
        System.out.println("----Click Apply for Jobs-----");
        WebElement applyJobs = driver.findElement(By.xpath("//input[@value='Apply for job']"));
        applyJobs.click();
        Thread.sleep(500);
        WebElement email = driver.findElement(By.xpath("//a[contains(text(),'abhiram@cklabs.com')]"));
        String emailToApplyJob = email.getText();
        System.out.println("Email To Apply Jobs: " + emailToApplyJob);

        driver.close();
    }

}
