package test.java.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    //гарантированно инициализируем веб-драйвер перед каждым тестом
    @BeforeMethod
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        //неявное ожидание 15секунд - объявляется единоразово, но применяется всегда
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod //закрывает весь браузер вне зависимости от результата теста
    public void tearDown() {
        driver.quit();
    }
}
