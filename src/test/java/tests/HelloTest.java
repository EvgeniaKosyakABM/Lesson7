package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/*public class HelloTest {
   public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");//переходит по ссылке
        //driver.close();//закрывает текущую вкладку браузера
        Thread.sleep(5000);//делает задержку

        By callBack = By.className("callback-btn"); //декларирует название элемента
       // By callBack = By.xpath("/a[@class='callback-btn'");
        WebElement callBackEl = driver.findElement(callBack); //находит элемент по ранее описаной декларации
        callBackEl.click();//обращаемся к ранее найденному элементу

        Thread.sleep(5000);//делает задержку
        By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail']");
        WebElement callBackMsgEl = driver.findElement(callBackMsg); //находим элемент И с вами свяжутся наши менеджеры
        String msg = callBackMsgEl.getText(); //присваеваем его переменной
        System.out.println(msg);// выводим на печать

        //нажимаем на сабмит и ждем что поля подсветятся красным цветом
        driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']")).click();
        Thread.sleep(500);//делает задержку
        //выводим цвет элемента
        String style = driver.findElement(By.xpath("//input[@name='name']")).getAttribute("style");
        System.out.println(style);

        //закрываем окошко Заполнить форму
        By exitBtn = By.xpath("(//*[@class='b-header-contacte__close-btn'])[1]");
        WebElement exitBtnEl = driver.findElement(exitBtn);
        exitBtnEl.click();
        Thread.sleep(2000);//делает задержку

        driver.quit();//закрывает весь браузер
    }
}*/




/*
public class HelloTest extends BaseTest {  //выносим общие действия в BaseTest и указываем здесь, что это наследник BaseTest

    @Test
    public void checkStyle() throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com/"); //переходит по ссылке    ???
        //ожидаем один из языков
        WebElement uaLan = driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"));
        WebElement ruLan = driver.findElement(By.xpath("(//a[text() = 'RU'])[1]"));
        WebElement enLan = driver.findElement(By.xpath("(//a[text() = 'EN'])[1]"));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(uaLan),
                ExpectedConditions.visibilityOf(ruLan),
                ExpectedConditions.visibilityOf(enLan)
        ));



        By callBack = By.className("callback-btn"); //декларирует название элемента
        // By callBack = By.xpath("/a[@class='callback-btn'");
        WebElement callBackEl = driver.findElement(callBack); //находит элемент по ранее описаной декларации
        wait.until(ExpectedConditions.elementToBeClickable(callBack));

        callBackEl.click();//обращаемся к ранее найденному элементу

        By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail']");
        //By callBackMsg = By.xpath("//*[@class='b-header-contacte__detail' and contains(text(), 'manager')]"); ??????
        WebElement callBackMsgEl = driver.findElement(callBackMsg); //находим элемент И с вами свяжутся наши менеджеры
        wait.until(ExpectedConditions.presenceOfElementLocated(callBack));

       // waitForPresence.until(ExpectedConditions.visibilityOf(callBackEl));
        //System.out.println(callBackMsgEl.getAttribute("outerHTML"));
        String msg = callBackMsgEl.getText(); //присваеваем его переменной
        System.out.println(msg);// выводим на печать

        //нажимаем на сабмит и ждем что поля подсветятся красным цветом
        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)); //ожидаем момента, когда эл-т становится кликабельным
        submitBtn.click();
        //Thread.sleep(500);//делает задержку

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        wait.until(ExpectedConditions.attributeContains(nameInput, "style", "border-color: red;"));
        //выводим цвет элемента
        String styleStyle = nameInput.getAttribute("style");
        System.out.println(styleStyle);

        String expectedValue = "border-color: red;";
        assertEquals(expectedValue, styleStyle);

        //driver.quit();//закрывает весь браузер
    }


}*/


