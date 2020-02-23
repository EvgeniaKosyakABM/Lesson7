package test.java.tests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        WebElement spinner = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this; //возвращает экземпляр текущего класса типа  HomePage
    }

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

    public HomePage openAbout() {
        WebElement aboutBtn = driver.findElement(By.xpath("//a[(contains(@href, 'about_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(aboutBtn));
        aboutBtn.click();
        return this;
    }

    public HomePage openVacancies() {
        WebElement vacancies = driver.findElement(By.xpath("//li[@id='menu-item-15362']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        return this;
    }

    public HomePage openEveningCourses() {
        WebElement eveningCousesBtn = driver.findElement(By.xpath("//a[(contains(@href, 'courses_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(eveningCousesBtn));
        eveningCousesBtn.click();
        return this;
    }

    public HomePage openCourses() {
        WebElement courses = driver.findElement(By.xpath("//li[@id='menu-item-7871']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(courses));
        courses.click();
        return this;
    }
}