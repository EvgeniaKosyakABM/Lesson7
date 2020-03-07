package test.java.tests.PO;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage {
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home page")
    public HomePage open() {
        logger.info("Open HomePage ");
        logger.debug("Open HomePage");
        driver.get(PropertyLoader.getProperty("url"));
        WebElement spinner = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this; //возвращает экземпляр текущего класса типа  HomePage
    }

    @Step("Select language{lang}")
    public HomePage selectLanguage(String lang) {
        logger.trace("Language is checked to " + lang);
        logger.debug("Language is checked to " + lang);
        logger.info("Это информационное сообщение! Language is checked to " + lang);
        logger.warn("Language is checked to " + lang);
        logger.error("Это сообщение ошибки. Language is checked to " + lang);
        logger.fatal("Language is checked to " + lang);
        WebElement uaLang = driver.findElement(By.xpath("(//a[@hreflang='" + lang + "'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(uaLang));
        uaLang.click();
        return this;
    }

    @Step("Open page About")
    public HomePage openAbout() {
        WebElement aboutBtn = driver.findElement(By.xpath("//a[(contains(@href, 'about_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(aboutBtn));
        aboutBtn.click();
        return this;
    }

    @Step("Open page Vacancies")
    public HomePage openVacancies() {
        WebElement vacancies = driver.findElement(By.xpath("//li[@id='menu-item-15362']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        return this;
    }

    @Step("Open page Evening courses")
    public HomePage openEveningCourses() {
        WebElement eveningCousesBtn = driver.findElement(By.xpath("//a[(contains(@href, 'courses_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(eveningCousesBtn));
        eveningCousesBtn.click();
        return this;
    }

    @Step("Open page Courses")
    public HomePage openCourses() {
        WebElement courses = driver.findElement(By.xpath("//li[@id='menu-item-7871']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(courses));
        courses.click();
        return this;
    }

    public HomePage BuyCourse() throws InterruptedException {
        WebElement BuyCourseElements = driver.findElement(By.cssSelector(".order-courses-btn"));
        wait.until(ExpectedConditions.elementToBeClickable(BuyCourseElements));
        BuyCourseElements.click();
        return this;
    }

    public HomePage openRandomCourses() {
        List<WebElement> courseElements = driver.findElements(By.cssSelector(".container_12 a"));
        int rand = (int) (Math.random() * (courseElements.size()));
        WebElement CourseRandom = courseElements.get(rand);
        System.out.println(CourseRandom.getAttribute("href"));
        CourseRandom.click();
        return this;
    }

    public HomePage openNumberCourses(int number) {
        List<WebElement> courseElements = driver.findElements(By.cssSelector(".container_12 a"));
        //int rand = (int) (Math.random() * (courseElements.size()));
        WebElement CourseNumber = courseElements.get(number);
        System.out.println(CourseNumber.getAttribute("href"));
        CourseNumber.click();
        return this;
    }

    public HomePage setFullname(String fullname) {
        WebElement fullnameInput = driver.findElement(By.id("name"));
        wait.until(ExpectedConditions.elementToBeClickable(fullnameInput));
        fullnameInput.sendKeys("" + fullname + "");
        return this;
    }

    public HomePage setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys("" + email + "");
        return this;
    }

    public HomePage setPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.id("phone"));
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
        phoneInput.sendKeys("" + phone + "");
        return this;
    }

    public HomePage privacyPolicy() {
        WebElement checkboxPrivacyPolicy = driver.findElement(By.cssSelector("#privacy-policy span"));
        checkboxPrivacyPolicy.click();
        return this;
    }

    public HomePage submit() throws InterruptedException {
        // WebElement submitBtn = driver.findElement(By.xpath("//div[@class='user-data-form__item user-data-form__item-button']//input[@type='submit']"));
        WebElement submitBtn = driver.findElement(By.cssSelector(".submit "));
        submitBtn.click();
        Thread.sleep(5000);
        return this;
    }

    public String message() {
        WebElement MessageEl = driver.findElement(By.cssSelector(".thanks-block h1"));
        wait.until(ExpectedConditions.visibilityOf(MessageEl));

        String text = MessageEl.getText();
        String text2 = text.substring(0, 21);
        return (text2);
    }
}
