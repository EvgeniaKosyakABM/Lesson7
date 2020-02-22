package test.java.tests.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CallbackPage extends BasePage {

    public CallbackPage(WebDriver driver) {
        super(driver);
    }

   /* //метод, необходимый для отнаследования
    public  CallbackPage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/vacancy/");
        return this;
    }*/

    public CallbackPage openCallback() {
        WebElement CallbackEl = driver.findElement(By.className("callback-btn"));
        wait.until(ExpectedConditions.visibilityOf(CallbackEl));
        CallbackEl.click();
        return this;
    }

    public CallbackPage setFullname(String fullname) {
        WebElement fullnameInput = driver.findElement(By.id("b-contacte__full-name"));
        wait.until(ExpectedConditions.elementToBeClickable(fullnameInput));
        fullnameInput.sendKeys("" + fullname + "");
        return this;
    }

    public CallbackPage setPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.id("b-contacte-phone-tel"));
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
        phoneInput.sendKeys("" + phone + "");
        return this;
    }

    public CallbackPage submit() {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']"));
        submitBtn.click();
        return this;
    }

    public String message() {
        WebElement MessEl = driver.findElement(By.xpath("//*[@class='b-header-contacte-phone-thank hidden']"));
        wait.until(ExpectedConditions.visibilityOf(MessEl));
        return MessEl.getText();
    }


    public String colorForm() {
        String color = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("style");
        return color;
    }

}
