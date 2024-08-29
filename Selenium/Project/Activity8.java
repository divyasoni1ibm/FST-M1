package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Activity8 {

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

        WebElement dashboard = driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]"));
        if(dashboard.isDisplayed()) {
            System.out.println("--------Logged In Successfully-------------------");
        }
        driver.close();
    }
}
