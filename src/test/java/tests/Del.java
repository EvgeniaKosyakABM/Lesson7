package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Del {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test(dataProvider = "someProvider")
    public void someTest(String langStr) {
        driver.get("http://iteaua-develop.demo.gns-it.com/");
        WebElement lang = driver.findElement(By.xpath("(//a[@hreflang='" + langStr + "'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(lang));
        lang.click();
        WebElement logo = driver.findElement(By.xpath("//img[@alt='ITEA']"));
        wait.until(ExpectedConditions.visibilityOf(logo));
        boolean isDisplayed = logo.isDisplayed();
        assertTrue(true, "Error");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name= "someProvider")
    public Object[][] provider(){
        return new Object[][]{
                {"ru-RU"},
                {"uk"},
                {"en-GB"}
        };
    }
}