package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver","path needs to be mentioned");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();
        }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        Thread.sleep( 3000);
        WebElement txtInputEmailAddress = driver.findElement(By.name("email"));
        txtInputEmailAddress.clear();
        Thread.sleep( 3000);
        txtInputEmailAddress.sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
//        driver.findElement(By.className("ladda-button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep( 5000);

//        List<WebElement> lblMessage =  driver.findElements(By.xpath("//*[text()='Dashboard']"));
//        String actualMessage = lblMessage.get(2).getText();
//        Assert.assertEquals(actualMessage, "Dashboard","Failed to Login:");

        driver.findElement(By.id("dropdownMenuProfile")).click();
        Thread.sleep( 3000);
        driver.findElement(By.xpath("//*[text()='Logout']")).click();

    }
}
