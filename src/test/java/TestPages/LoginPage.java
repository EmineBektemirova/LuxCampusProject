package TestPages;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static TestPages.DriverSetUp.driver;

@Feature("Login functionality")
public class LoginPage {
    By emailAddress = By.id("exampleInputEmail1");
    By password = By.name("password");
    By submitButton = By.xpath("//button[@type='submit']");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));

    public void setEmail(String emailText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailAddress));
        driver.findElement(emailAddress).sendKeys(emailText);
    }

    public void setPassword(String passwordText) {
        wait.until(ExpectedConditions.elementToBeClickable(password));
        driver.findElement(emailAddress).sendKeys(passwordText);
    }

    public void submitButtonClick() {
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public void ValidationMessageLoginPage() {
        String validationMessageLoginPage = driver.findElement(By.name("email")).getAttribute("validationMessage");
        Assertions.assertEquals("Адрес электронной почты должен содержать символ \"@\". В адресе \"emine.testgmail.com\" отсутствует символ \"@\".",
                validationMessageLoginPage);
    }

    public void openLoginPage() {

        driver.get("http://online-sh.herokuapp.com/login");
    }

    public void checkEnabledEmailAddressField() {
        boolean enabledEmailAddress = driver.findElement(emailAddress).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(emailAddress));
        Assertions.assertTrue(enabledEmailAddress);
    }

    public void checkEnabledPasswordField() {
        boolean enabledPasswordField = driver.findElement(password).isEnabled();
        wait.until(ExpectedConditions.presenceOfElementLocated(password));
        Assertions.assertTrue(enabledPasswordField);
    }

    public void checkEnabledSubmitButton() {
        boolean enabledSubmitButton = driver.findElement(submitButton).isEnabled();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        Assertions.assertTrue(enabledSubmitButton);
    }

    public void UserLoginProcess(String emailText, String passwordText) {
        driver.get("http://online-sh.herokuapp.com/login");
        driver.findElement(emailAddress).sendKeys(emailText);
        driver.findElement(password).sendKeys(passwordText);
        driver.findElement(submitButton).click();
    }

    public void checkUserRedirectToProductsPage() {
        String productsPageUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(productsPageUrl));
        Assertions.assertEquals("http://online-sh.herokuapp.com/products", productsPageUrl);
    }
}
