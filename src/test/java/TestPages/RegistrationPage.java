package TestPages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegistrationPage {
    By name = By.name("name");
    By lastName = By.name("last_Name");
    By emailAddress = By.id("exampleInputEmail1");
    By password = By.xpath("//input[@type='password']");
    By submitButtonRegister = By.xpath("//button[contains(@class,'btn-primary')]");

    public void openRegistrationPage() {

        DriverSetUp.driver.get("http://online-sh.herokuapp.com/registration");
    }

    public void UserRegistrationProcess(String EnterName,String EnterLastName,String EnterEmailAddress,String EnterPassword) {
        DriverSetUp.driver.get("http://online-sh.herokuapp.com/registration");
        DriverSetUp.driver.findElement(name).sendKeys(EnterName);
        DriverSetUp.driver.findElement(lastName).sendKeys(EnterLastName);
        DriverSetUp.driver.findElement(emailAddress).sendKeys(EnterEmailAddress);
        DriverSetUp.driver.findElement(password).sendKeys(EnterPassword);
        DriverSetUp.driver.findElement(submitButtonRegister).click();
    }

    public void NameFieldPresentRegistrationPage() {

        boolean nameDisplayed = DriverSetUp.driver.findElement(name).isDisplayed();
        Assertions.assertTrue(nameDisplayed);
    }

    public void lastNameFieldPresentRegistrationPage() {

        boolean lastNameDisplayed = DriverSetUp.driver.findElement(lastName).isDisplayed();
        Assertions.assertTrue(lastNameDisplayed);
    }

    public void emailAddressFieldPresentRegistrationPage() {

        boolean emailAddressDisplayed = DriverSetUp.driver.findElement(emailAddress).isDisplayed();
        Assertions.assertTrue(emailAddressDisplayed);
    }

    public void passwordFieldPresentRegistrationPage() {

        boolean passwordDisplayed = DriverSetUp.driver.findElement(password).isDisplayed();
        Assertions.assertTrue(passwordDisplayed);
    }

    public void submitButtonRegisterPresentRegistrationPage() {

        boolean submitButtonRegisterDisplayed = DriverSetUp.driver.findElement(submitButtonRegister).isDisplayed();
        Assertions.assertTrue(submitButtonRegisterDisplayed);
    }

    public void ValidationMessageRegistrationPage() {
        String validationMessage = DriverSetUp.driver.findElement(By.id("exampleInputEmail1")).getAttribute("validationMessage");
        Assertions.assertEquals("Адрес электронной почты должен содержать символ \"@\". В адресе \"emine.testgmail.com\" отсутствует символ \"@\".",
                validationMessage);
    }
    public void checkUserRedirectToLoginPage() {
        String loginPageUrl = DriverSetUp.driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/login", loginPageUrl);
    }
}



