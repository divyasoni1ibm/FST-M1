package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity2 {
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            // Open the browser
            driver.get("https://alchemy.hguy.co/jobs/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String expectedHeader = "Welcome to Alchemy Jobs";
            String originalHeader = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Alchemy Jobs')]")).getText();
            System.out.println("Original Header :" + originalHeader);
            try {
                Assert.assertEquals(originalHeader, expectedHeader);
                System.out.println("Original Header :" + originalHeader + "  --MATCHES with Expected Header :" + expectedHeader);
            } catch (Exception e) {
                System.out.println("Original Header :" + originalHeader + "  --DOES NOT MATCH with Expected Header :" + expectedHeader);
            }

            driver.close();
        }
}
