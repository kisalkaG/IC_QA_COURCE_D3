package net.phptravels;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class CustomerCreationTest4 {
    LoginPage loginPage;
    HomePage homePage;
    CustomerManagementPage customerManagementPage;
    CustomerCreationPage customerCreationPage;
    
    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        loginPage = new LoginPage();
        homePage = loginPage.loginSuccess("gunathilakakisalka@gmail.com","demoadmin");
        customerManagementPage = homePage.selectAccountMenu().selectCustomerMenu();
        customerCreationPage = customerManagementPage.addCustomer();
    }

    @Test
    public void testRegisterNewUser() {
        customerCreationPage
                .setFirstName("Imperial")
                .setLastName("College")
                .setEmail("info@icitb.lk")
                .setPassword("admin@1234")
                .setMobile("0213223453")
                .selectCountryByName("Malaysia")
                .setAddress1("Borella")
                .setAddress2("Colombo")
                .submit();
    }
}
