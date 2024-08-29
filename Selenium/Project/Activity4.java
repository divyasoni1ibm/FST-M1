package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedHeader = "Quia quis non";
        String originalHeader = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
        System.out.println("2nd Original Header :" + originalHeader);
        try {
            Assert.assertEquals(originalHeader, expectedHeader);
            System.out.println("2nd Original Header :" + originalHeader + "  --MATCHES with 2nd Expected Header :" + expectedHeader);
        } catch (Exception e) {
            System.out.println("2nd Original Header :" + originalHeader + "  --DOES NOT MATCH with 2nd Expected Header :" + expectedHeader);
        }

        driver.close();
    }
}
