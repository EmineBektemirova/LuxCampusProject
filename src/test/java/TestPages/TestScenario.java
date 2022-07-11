package TestPages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestScenario {
    private static LoginPage loginPage;
    private static RegistrationPage registrationPage;
    private static ProductsPage productsPage;

    @BeforeAll
    static void unitTest(){

        DriverSetUp webDriverSetUp = new DriverSetUp();

        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        productsPage = new ProductsPage();
    }
    //LOGIN PAGE TESTS
    @Test
    public void testLogin() {
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword);
        // Then
        loginPage.checkUserRedirectToProductsPage();
    }
    @Test
    public void emailFieldLoginPageActive(){
        loginPage.openLoginPage();
        loginPage.checkEnabledEmailAddressField();
    }
    @Test
    public void passwordFieldLoginPageActive(){
        loginPage.openLoginPage();
        loginPage.checkEnabledPasswordField();
    }
    @Test
    public void submitButtonLoginPageActive(){
        loginPage.openLoginPage();
        loginPage.checkEnabledSubmitButton();
    }
    @Test
    public void testValidationMessageEmailLoginPage() {
        //GIVEN
        String existingUserEmail = "emine.testgmail.com";
        //WHEN
        loginPage.openLoginPage();
        loginPage.setEmail(existingUserEmail);
        loginPage.submitButtonClick();
        //THEN
        loginPage.ValidationMessageLoginPage();
    }
    //REGISTRATION PAGE TESTS
    @Test
    public void testRegistration(){
        //Given
        String existingUserName = "Emine";
        String existingUserLastName = "test";
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        registrationPage.UserRegistrationProcess(existingUserName,existingUserLastName,existingUserEmail,existingUserPassword);
        //Then
        registrationPage.checkUserRedirectToLoginPage();
    }
    @Test
    public void validationMessageRegistrationPage(){
        //Given
        String existingUserName = "Emine";
        String existingUserLastName = "test";
        String existingUserEmail = "emine.testgmail.com";
        String existingUserPassword = "99911";
        //When
        registrationPage.UserRegistrationProcess(existingUserName,existingUserLastName,existingUserEmail,existingUserPassword);
        //Then
        registrationPage.ValidationMessageRegistrationPage();
    }

    @Test
    public void nameFieldORegistrationPageDisplayed(){
        registrationPage.openRegistrationPage();
        registrationPage.NameFieldPresentRegistrationPage();
    }
    @Test
    public void lastNameFieldRegistrationPageDisplayed(){
        registrationPage.openRegistrationPage();
        registrationPage.lastNameFieldPresentRegistrationPage();
    }
    @Test

    public void emailFieldRegistrationPageDisplayed(){
        registrationPage.openRegistrationPage();
        registrationPage.emailAddressFieldPresentRegistrationPage();
    }
    @Test

    public void passwordFieldRegistrationPageDisplayed(){
        registrationPage.openRegistrationPage();
        registrationPage.passwordFieldPresentRegistrationPage();
    }
    @Test

    public void registerButtonRegistrationPageDisplayed(){
        registrationPage.openRegistrationPage();
        registrationPage.submitButtonRegisterPresentRegistrationPage();
    }

    //PRODUCTS PAGE TESTS
    @Test
    public void testRedirectToAddProductPage() {
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword);
        productsPage.openProductsPage();
        productsPage.clickAddNewProductButton();
        productsPage.openAddProductsPage();
        // Then
        checkUserRedirectToAddProductPage();
    }
    private void checkUserRedirectToAddProductPage() {
        String addProductPageUrl = DriverSetUp.driver.getCurrentUrl();
        String expectedResultLink = "http://online-sh.herokuapp.com/products/add";
        Assertions.assertEquals(expectedResultLink, addProductPageUrl);
    }
    @Test
    public void testUserAddNewProduct(){
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword );
        productsPage.openProductsPage();
        productsPage.clickAddNewProductButton();
        productsPage.addNewProductName("TestProduct");
        productsPage.addNewPriceName("505");
        productsPage.clickSubmitAddNewProductButton();

        checkUserRedirectToBackProductsPage();

    }
    private void checkUserRedirectToBackProductsPage() {
        String backToProductsPageUrl = DriverSetUp.driver.getCurrentUrl();
        String expectedResultLink = "http://online-sh.herokuapp.com/products";
        Assertions.assertEquals(expectedResultLink, backToProductsPageUrl);
    }
    @Test
    public void testUpdateTheProduct(){
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword);
        productsPage.openProductsPage();
        productsPage.clickUpdateProductButton();
        productsPage.clearProductName();
        productsPage.updateProductName("TestUpdateProduct");
        productsPage.clearProductPrice();
        productsPage.updateProductPrice("75");
        productsPage.submitUpdatedProductButton();
        //Then
        checkUpdateTheProduct();
    }
    private void checkUpdateTheProduct() {
        WebDriverWait wait = new WebDriverWait( DriverSetUp.driver, Duration.ofMillis(500L));
        WebElement updatedElement = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("(//*[text()[contains(., 'TestUpdated7')]])")));
        Assertions.assertTrue(updatedElement.isDisplayed());
    }

    @Test
    public void testDeleteProduct(){
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When
        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword );
        productsPage.clickDeleteProductButton();
        //Then
        checkDeleteTheProduct();

    }
    private void checkDeleteTheProduct() {
        String actualNameProducts = null;
        String expectedNameProducts = null;
        Assertions.assertEquals(expectedNameProducts,actualNameProducts);
    }

    @Test
    @Step("Valid price format is 00,0000. If the test fails, then the field product price at Add product page is valid")
    public void testPriceFormatAddProductPageNegative() {
        //GIVEN
        //WHEN
        productsPage.openProductsPage();
        productsPage.clickAddNewProductButton();
        productsPage.addNewProductName("testFormatNegative");
        productsPage.updateProductPrice("505,99995");
        productsPage.clickAddNewProductButton();
        //THEN
        productsPage.ValidationMessageAddProductPage();
    }

    @Test
    public void testLogOutTheProductPage(){
        //Given
        String existingUserEmail = "emine.test@gmail.com";
        String existingUserPassword = "99911";
        //When

        loginPage.UserLoginProcess(existingUserEmail,existingUserPassword );
        productsPage.clickLogOutButtonProductPage();

        //Then
        checkReturnToTheLoginPage();

    }
    private void checkReturnToTheLoginPage() {
        String actualNameProductsPage = "http://online-sh.herokuapp.com/login";
        String expectedPage = DriverSetUp.driver.getCurrentUrl();
        Assertions.assertEquals(expectedPage,actualNameProductsPage);
    }

   @AfterAll
   @Step("Quit browser")
   static void closeDriver(){

        DriverSetUp.driver.quit();
   }
}
