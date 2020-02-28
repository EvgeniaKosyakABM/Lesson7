package test.java.tests;

        import io.qameta.allure.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import test.java.tests.PO.CallbackPage;
        import test.java.tests.PO.EveningCoursesPage;
        import test.java.tests.PO.HomePage;
        import test.java.tests.PO.VacancyPage;
        import test.java.utils.RetryAnalizer;

        import java.util.ArrayList;
        import java.util.List;

        import static org.testng.Assert.assertEquals;
        import static org.testng.Assert.assertTrue;


public class ForPO extends BaseTest {
    HomePage homePage;
    VacancyPage vacancyPage;
    CallbackPage callbackPage;


    @BeforeMethod
    public void PageLoad() {
        homePage = new HomePage(driver);
        vacancyPage = new VacancyPage(driver);
        callbackPage = new CallbackPage(driver);
    }

    @Link("https://google.com")
    @TmsLink("B-1")
    @Issues({
            @Issue("AAA-1"),
            @Issue("AAA-134")
    })
    @Story("Add to card")
    @Feature("Add t-short")
    @Test //(retryAnalyzer = RetryAnalizer.class)
    public void anyTest() {
        homePage
                .open()
                .selectLanguage("uk")
                .openAbout()
                .openVacancies();
        vacancyPage
                .selectVacancy("Викладач UX")
                .setName("Vova")
                .setEmail("email@email.com")
                .submit();
        String actualMsg = vacancyPage.getPhoneErrorMsg();
        String expectedMsg = "Поле не має бути пустим";
        //assertTrue(false);
        assertEquals(actualMsg, expectedMsg);
    }

    @Link("https://google.com")
    @TmsLink("B-1")
    @Issues({
            @Issue("AAA-1"),
            @Issue("AAA-134")
    })
    @Story("Add to card")
    @Feature("Delete t-short")
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


   /* @Test //негативный тест для д/з 8
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
*/

   /* @Test //тест, вытаскивающий все языки и проверяем все ли они есть в наличии
    public void checkLang() throws InterruptedException {
        String langExpected[] = {"UA", "EN", "RU"};

        homePage.open();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"))));

        List<WebElement> langElements = driver.findElements(By.xpath("(//ul[@class = 'lang'])[1]//a"));
        List<String> langActual = new ArrayList<String>();

        for (WebElement el : langElements) {
            langActual.add(el.getText());
        }
        for (String lang : langExpected) {
            boolean isContains = langActual.contains(lang);
            assertTrue(isContains);
        }
    }*/


   /* @Test // д/з 9, д/з 10
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
    }*/


    /*@AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}

