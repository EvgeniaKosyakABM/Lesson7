package test.java.tests.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
        WebDriver driver;
        WebDriverWait wait;

        public BasePage(WebDriver driver){
            this.driver = driver;
            wait = new WebDriverWait(this.driver, 30);
        }

       // public  abstract BasePage open();
}
