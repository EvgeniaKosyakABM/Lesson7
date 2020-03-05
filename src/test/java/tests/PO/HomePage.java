package test.java.tests.PO;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.utils.PropertyLoader;

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

}
