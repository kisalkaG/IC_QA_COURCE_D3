package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CustomerCreationTest1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/api/admin");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep( 3000);
        List<WebElement> menuElements = driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElements.get(2).click();
        Thread.sleep( 3000);
//        driver.findElement(By.xpath("//*[@href='https://phptravels.net/api/admin/accounts/customers/']")).click();
        driver.findElement(By.linkText("Customers")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @Test
    public void testCreateNewCustomer() throws InterruptedException {
        driver.findElement(By.name("fname")).sendKeys("Imperial");
        driver.findElement(By.name("lname")).sendKeys("College");
        driver.findElement(By.name("email")).sendKeys("info@icitb.lk");
        driver.findElement(By.name("password")).sendKeys("Admin@123");
        driver.findElement(By.name("mobile")).sendKeys("+943562783");
        driver.findElement(By.name("address1")).sendKeys("Borella");
        driver.findElement(By.name("address2")).sendKeys("Colombo");
        Select dropDownCountry = new Select(driver.findElement(By.name("country")));

        dropDownCountry.selectByVisibleText("Malaysia");
        Thread.sleep( 3000);
        dropDownCountry.selectByValue("LK");
        Thread.sleep( 3000);
        dropDownCountry.selectByIndex(5);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}







