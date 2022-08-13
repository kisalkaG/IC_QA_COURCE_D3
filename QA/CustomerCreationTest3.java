package net.phptravels;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class CustomerCreationTest3 {

    LoginPage loginPage;
    HomePage homePage;
    CustomerManagementPage customerManagementPage;

    CustomerCreationPage customerCreationPage;

    @BeforeMethod
    public void setUp() {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        loginPage = new LoginPage();
        loginPage.loginSuccess("gunathilakakisalka@gmail.com","demoadmin");
        homePage = new HomePage();
        homePage.selectAccountMenu();
        homePage.selectCustomerMenu();
        customerManagementPage =new CustomerManagementPage();
        customerManagementPage.addCustomer();
        customerCreationPage =new CustomerCreationPage();
    }

    @Test
    public void testRegisterNewUser() {
        customerCreationPage.setFirstName("Imperial");
        customerCreationPage.setLastName("College");
        customerCreationPage.setEmail("info@icitb.lk");
        customerCreationPage.setPassword("Admin@123");
        customerCreationPage.setMobile("+943562783");
        customerCreationPage.setAddress1("Borella");
        customerCreationPage.setAddress2("Colombo");
        customerCreationPage.selectCountryByName("Malaysia");
        customerCreationPage.submit();
    }
}
