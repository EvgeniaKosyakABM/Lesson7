package test.java.tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshot;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    WebDriverWait wait;

    //гарантированно инициализируем веб-драйвер перед каждым тестом
    @BeforeMethod
    public  void setUp(ITestResult context){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        context.setAttribute("webDriver", driver);
        //неявное ожидание 15секунд - объявляется единоразово, но применяется всегда
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod //закрывает весь браузер вне зависимости от результата теста
    public void tearDown() {
        saveScreenshot();
        driver.quit();
    }

    //массив скриншотов делаем как поток байтов
    @Attachment(value = "screen", type = "image/png")
    private byte[] saveScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
