package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Activity9 {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement userName = driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("root");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_pass']"));
        password.sendKeys("pa$$w0rd");
        WebElement login = driver.findElement(By.xpath("//input[@id='wp-submit']"));
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement jobListings = driver.findElement(By.xpath("//div[@id='adminmenuwrap']/ul[@id='adminmenu']/li[@id='menu-posts-job_listing']/a[1]"));
        jobListings.click();
        Thread.sleep(50);

        WebElement addNewJob = driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/a[1]"));
        addNewJob.click();
        Thread.sleep(50);


        WebElement closeDialogue = driver.findElement(By.xpath("//div[@class='components-modal__header']/button"));
        Actions action = new Actions(driver);
        action.moveToElement(closeDialogue).click().perform();

        WebElement position = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        position.click();
        position.sendKeys("Assistant Trainer");

        WebElement applicationEmail = driver.findElement(By.xpath("//input[@id='_application']"));
        applicationEmail.click();
        applicationEmail.clear();;
        applicationEmail.sendKeys("swasin21@in.ibm.com");
        WebElement companyWebsite = driver.findElement(By.xpath("//input[@id='_company_website']"));
        companyWebsite.sendKeys("https://lms.training-support.net/alchemy");
        WebElement location = driver.findElement(By.xpath("//input[@id='_job_location']"));
        location.sendKeys("https://lms.training-support.net/alchemy");
        WebElement companyName = driver.findElement(By.xpath("//input[@id='_company_name']"));
        companyName.sendKeys("LMS Training Institute");

        WebElement submitbtn = driver.findElement(By.xpath("//button[contains(text(),'Publish…')]"));
        submitbtn.click();
        driver.findElement(By.xpath("//button[normalize-space()='Publish']")).click();
        Thread.sleep(500);

        WebElement jobPublished = driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-published']"));
        String job = jobPublished.getText();
        if(job.equals("Published")) {
            System.out.println("--------------Job was Published successfully-----------------");
        } else {
            System.out.println("--------------Job was not Published successfully-----------------");
        }
        driver.close();
    }
}
