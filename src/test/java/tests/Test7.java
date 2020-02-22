package test.java.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test7 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        Thread.sleep(2000);

        By phone = By.xpath("//div[@class='phones-block']/a");
        //By phone = By.className("phones-block"); // второй вариант
        WebElement phoneEl = driver.findElement(phone);
        String numPhone = phoneEl.getText();
        String numPhoneRes = numPhone.replace(" (", "").replace(") ", "").replace(" ", "").substring(3);
        System.out.println(numPhoneRes);

        driver.quit();
    }
}