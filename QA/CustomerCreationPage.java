package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.TestApp;

import java.time.Duration;

public class CustomerCreationPage {

    WebDriver driver = TestApp.getInstance().getDriver();

    public CustomerCreationPage setFirstName(String firstName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("fname"),Duration.ofSeconds(5));
        driver.findElement(By.name("fname")).sendKeys(firstName);
        return this;
    }

    public CustomerCreationPage setLastName(String lastName){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("lname"),Duration.ofSeconds(5));
        driver.findElement(By.name("lname")).sendKeys(lastName);
        return this;
    }

    public CustomerCreationPage setEmail(String email){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("email"),Duration.ofSeconds(5));
        driver.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public CustomerCreationPage setPassword(String password){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("password"),Duration.ofSeconds(5));
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public CustomerCreationPage setMobile(String mobile){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("mobile"),Duration.ofSeconds(5));
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        return this;
    }

    public CustomerCreationPage setAddress1(String address1){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("address1"),Duration.ofSeconds(5));
        driver.findElement(By.name("address1")).sendKeys(address1);
        return this;
    }

    public CustomerCreationPage setAddress2(String address2){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("address2"),Duration.ofSeconds(5));
        driver.findElement(By.name("address2")).sendKeys(address2);
        return this;
    }

    public CustomerCreationPage selectCountryByName(String country){
        TestApp.getInstance().waitUntilNextElementAppears(By.name("country"),Duration.ofSeconds(5));
        Select dropDownCountry = new Select(driver.findElement(By.name("country")));
        dropDownCountry.selectByVisibleText("country");
        return this;
    }

    public CustomerManagementPage submit(){
        TestApp.getInstance().waitUntilNextElementAppears(By.xpath("//button[@type='submit']"),Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        return new CustomerManagementPage();
    }
}
