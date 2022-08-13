package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    public void loginSuccess(WebDriver driver,String userName, String password){
        driver.findElement(By.name("userName")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
