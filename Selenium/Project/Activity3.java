package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity3 {
        public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Identify Image
       WebElement imgSrc =  driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
       //Get Image src
       String imageUrl = imgSrc.getAttribute("src");
       System.out.println("Image Src Url :: "  + imageUrl);
       driver.close();
    }
}
