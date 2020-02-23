package test.java.tests.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VacancyPage extends BasePage {
    //Logger logger = LogManager.getLogger(VacancyPage.class);

    public VacancyPage(WebDriver driver) {
        super(driver);
    }

    //метод, необходимый для отнаследования
    public VacancyPage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/vacancy/");
        return this;
    }

    public VacancyPage selectVacancy(String vacancy) {
        WebElement uxVacancy = driver.findElement(By.xpath("//a//h2[text()='" + vacancy + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(uxVacancy));
        uxVacancy.click();
        return this;
    }

    public VacancyPage setName(String name) {
        WebElement nameInput = driver.findElement(By.id("names"));
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys("SomeName");
        return this;
    }

    public VacancyPage setEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys("email@email.com");
        return this;
    }

    public VacancyPage submit() {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='submit-btn']/input[@name='ok']"));
        submitBtn.click();
        return this;
    }

    public String getPhoneErrorMsg() {
        WebElement phoneMsg = driver.findElement(By.xpath("(//label[@for='telephone']/span)[2]"));
        wait.until(ExpectedConditions.visibilityOf(phoneMsg));
        return phoneMsg.getText();
    }
}
