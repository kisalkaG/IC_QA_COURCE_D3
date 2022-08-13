package net.phptravels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.PropertyFileReader;

public class CustomerCreationTest2 {
    PropertyFileReader prop = new PropertyFileReader();
    String url = prop.getProperty("config","url");
    WebDriver driver;
    Login login;
    Home home;
    CustomerManagement cusMgt;
    CustomerCreation cusCrt;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        login = new Login();
        login.loginSuccess(driver,"gunathilakakisalka@gmail.com","demoadmin");
        home = new Home();
        home.selectAccountMenu(driver);
        home.selectCustomerMenu(driver);
        cusMgt = new CustomerManagement();
        cusMgt.addCustomer(driver);
        cusCrt = new CustomerCreation();
    }

    @Test
    public void testRegisterUser() {
        cusCrt.setFirstName(driver,"Imperial");
        cusCrt.setLastName(driver,"College");
        cusCrt.setEmail(driver,"info@icitb.lk");
        cusCrt.setPassword(driver,"Admin@123");
        cusCrt.setMobile(driver,"+943562783");
        cusCrt.setAddress1(driver,"Borella");
        cusCrt.setAddress2(driver,"Colombo");
        cusCrt.selectCountryByName(driver,"Malaysia");
        cusCrt.submit(driver);
    }
}
