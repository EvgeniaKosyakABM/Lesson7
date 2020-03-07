package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.PO.*;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWork extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;
    CallbackPage callbackPage;


    @BeforeMethod
    public void PageLoad() {
        homePage = new HomePage(driver);
        vacancyPage = new VacancyPage(driver);
        callbackPage = new CallbackPage(driver);
    }

    @Test //позитивный тест для д/з 8
    public void TestPositiveHW8() {
        homePage.open();
        callbackPage.openCallback()
                .setFullname("EvgeniaTest")
                .setPhone("0684103225")
                .submit();
        String actualMess = callbackPage.message();
        String expectedMess = "Спасибо!\n" +
                "Наш менеджер свяжется с Вами.";
        assertEquals(actualMess, expectedMess);
    }


    @Test //негативный тест для д/з 8
    public void TestNegativeHW8() {
        homePage.open();
        callbackPage
                .openCallback()
                .setFullname("")
                .setPhone("")
                .submit();
        String actualMess = callbackPage.colorForm();
        String expectedMess = "border-color: red;";
        assertEquals(actualMess, expectedMess);
    }


    @Test // д/з 9
    public void checkCourse() throws InterruptedException {
        String courseExpected[] = {"Тестування", "Frontend development", "JS development", "Веб-дизайн",
                "PHP", "Java programming", "Python", "Data Science/Machine Learning",
                "C# /.NET development", "C++", "Game Development", "DEVOPS",
                "Digital Marketing", "Управління персоналом", "Управління проектами", "Mobile development",
                "Відеомонтаж", "Cisco", "Go development", "Кібербезпека",
                "Менеджмент"};
        homePage
                .open()
                .selectLanguage("uk")
                .openEveningCourses()
                .openCourses();

        List<WebElement> courseElements = driver.findElements(By.cssSelector(".container_12 h2"));
        List<String> courseActual = new ArrayList<String>();

        for (WebElement el : courseElements) {
            courseActual.add(el.getText());
        }

        for (String course : courseExpected) {
            boolean isContains = courseActual.contains(course);
            assertTrue(isContains);
        }
    }


    /*@Test(dataProvider = "locationCourseProvider") // д/з 10
    public void checkCourseLocation(String locCourse1, boolean res1,
                                    String locCourse2, boolean res2,
                                    String locCourse3, boolean res3,
                                    String locCourse4, boolean res4,
                                    boolean result) throws InterruptedException {
        homePage
                .open()
                .selectLanguage("uk")
                .openEveningCourses()
                .openCourses()
                .openRandomCourses()
                .BuyCourse();
        WebElement checkbox1 = driver.findElement(By.cssSelector("#" + locCourse1));
        boolean resSelected1 = checkbox1.isSelected() == res1;
        WebElement checkbox2 = driver.findElement(By.cssSelector("#" + locCourse2));
        boolean resSelected2 = checkbox2.isSelected() == res2;
        WebElement checkbox3 = driver.findElement(By.cssSelector("#" + locCourse3));
        boolean resSelected3 = checkbox3.isSelected() == res3;
        WebElement checkbox4 = driver.findElement(By.cssSelector("#" + locCourse4));
        boolean resSelected4 = checkbox4.isSelected() == res4;
        assertEquals(resSelected1 & resSelected2 & resSelected3 & resSelected4, result);
    }

    @DataProvider(name = "locationCourseProvider")
    public Object[][] provider() {
        return new Object[][]{
                {"location1", true, "location2", false, "location3", false, "input-privacy-policy", false, true},
                {"location1", true, "location2", true, "location3", false, "input-privacy-policy", false, false},
                {"location1", true, "location2", false, "location3", true, "input-privacy-policy", false, false},
                {"location1", true, "location2", false, "location3", false, "input-privacy-policy", true, false},
                {"location1", false, "location2", false, "location3", false, "input-privacy-policy", false, false}
        };
    }*/

    @Test(dataProvider = "locationCourseProvider") // д/з c Дата провайдером
    public void checkCourseLocation(int number,
                                    String locCourse1, boolean res1,
                                    String locCourse2, boolean res2,
                                    String locCourse3, boolean res3,
                                    String locCourse4, boolean res4,
                                    boolean result) throws InterruptedException {
        homePage
                .open()
                .selectLanguage("uk")
                .openEveningCourses()
                .openCourses()
                .openNumberCourses(number)
                .BuyCourse();
        WebElement checkbox1 = driver.findElement(By.cssSelector("#" + locCourse1));
        boolean resSelected1 = checkbox1.isSelected() == res1;
        WebElement checkbox2 = driver.findElement(By.cssSelector("#" + locCourse2));
        boolean resSelected2 = checkbox2.isSelected() == res2;
        WebElement checkbox3 = driver.findElement(By.cssSelector("#" + locCourse3));
        boolean resSelected3 = checkbox3.isSelected() == res3;
        WebElement checkbox4 = driver.findElement(By.cssSelector("#" + locCourse4));
        boolean resSelected4 = checkbox4.isSelected() == res4;
        assertEquals(resSelected1 & resSelected2 & resSelected3 & resSelected4, result);
    }

    @DataProvider(name = "locationCourseProvider")
    public Object[][] provider() {
        return new Object[][]{
                {1, "location1", true, "location2", false, "location3", false, "input-privacy-policy", false, true},
                {5, "location1", true, "location2", true, "location3", false, "input-privacy-policy", false, false},
                {10, "location1", true, "location2", false, "location3", true, "input-privacy-policy", false, false},
                {15, "location1", true, "location2", false, "location3", false, "input-privacy-policy", true, false},
                {20, "location1", false, "location2", false, "location3", false, "input-privacy-policy", false, false}
        };
    }

    @Test // д/з 11
    public void registrationCourse() throws InterruptedException {
        homePage
                .open()
                .selectLanguage("uk")
                .openEveningCourses()
                .openCourses()
                .openRandomCourses()
                .BuyCourse()
                .setFullname("EvgeniaTest")
                .setEmail("evgenia.kosyak@gmail.com")
                .setPhone("0684100000")
                .privacyPolicy()
                .submit();
        String actualMess = homePage.message();
        String expectedMess = "Ваша заявка прийнята.";
        assertEquals(actualMess, expectedMess);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
