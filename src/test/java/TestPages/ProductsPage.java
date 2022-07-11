package TestPages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    By productName = By.id("exampleInputProduct1");
    By productPrice = By.xpath("//input[@id='exampleInputPrice1']");
    By updateProductName = By.xpath("//input[@id ='exampleInputProduct1']");
    By updateProductPrice = By.xpath("//input[@id ='exampleInputPrice1']");
    By AddNewProductButton = By.xpath("(//a[@class='btn btn-outline-success'])");
    By updateButton = By.xpath("//button[@class='btn btn-outline-warning']");
    By deleteButton = By.xpath("(//button[@class ='btn btn-outline-danger']");
    By logOutButton = By.xpath("//a[@class ='btn btn-dark']");

    public void openProductsPage() {

        DriverSetUp.driver.get("http://online-sh.herokuapp.com/products");
    }
    public void openAddProductsPage() {

        DriverSetUp.driver.get("http://online-sh.herokuapp.com/products/add");

    }
    public void clickAddNewProductButton(){
        WebElement addNewProductButton = DriverSetUp.driver.findElement(By.xpath("(//a[@href='/products/add'])"));
        ((JavascriptExecutor)DriverSetUp.driver).executeScript("arguments[0].click()", addNewProductButton);
    }
    public void addNewProductName(String EnterNewProductName){
        DriverSetUp.driver.findElement(productName).sendKeys(EnterNewProductName);
    }
    public void addNewPriceName(String EnterNewPriceName){
        DriverSetUp.driver.findElement(productPrice).sendKeys(EnterNewPriceName);
    }
    public void clickSubmitAddNewProductButton(){

        WebElement updateButton = DriverSetUp.driver.findElement(By.xpath("//button[@type ='submit']"));
        updateButton.submit();
    }
    public void clickUpdateProductButton() {

        WebElement updateButton = DriverSetUp.driver.findElement(By.xpath("//button[text() = 'Update']/preceding-sibling::input[@value='366']"));
        updateButton.submit();
    }
    public void updateProductName(String updateProductNameText){
        DriverSetUp.driver.findElement(updateProductName).sendKeys(updateProductNameText);
    }
    public void updateProductPrice(String updatePriceName){
        DriverSetUp.driver.findElement(updateProductPrice).sendKeys(updatePriceName);
    }
    public void submitUpdatedProductButton(){

        DriverSetUp.driver.findElement(By.xpath("//button[@type = 'submit']")).submit();
    }
    public void clearProductName(){

        DriverSetUp.driver.findElement(updateProductName).clear();
    }
    public void clearProductPrice(){

        DriverSetUp.driver.findElement(updateProductPrice).clear();
    }
    public void clickDeleteProductButton(){

        WebElement logOutButton = DriverSetUp.driver.findElement(By.xpath("//button[@class='btn btn-outline-danger']"));
        ((JavascriptExecutor) DriverSetUp.driver).executeScript("arguments[0].click()", logOutButton);
    }
    public void clickLogOutButtonProductPage(){
        WebElement logOutButton = DriverSetUp.driver.findElement(By.xpath("//a[@href ='/logout']"));
        ((JavascriptExecutor) DriverSetUp.driver).executeScript("arguments[0].click()", logOutButton);
    }
    public void ValidationMessageAddProductPage() {
        String validationMessage = DriverSetUp.driver.findElement(By.xpath("//input[@step='0.0001']")).getAttribute("validationMessage");
        Assertions.assertEquals("Введите допустимое значение. Ближайшие допустимые значения: 505,9999 и 506.",
                validationMessage);
    }
}
