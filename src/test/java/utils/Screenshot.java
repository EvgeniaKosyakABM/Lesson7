package test.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {
    WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void saveScreenshot(ITestResult result) {
        String delimiter = System.getProperty("os.name").equals("Windows 10") ? "\\" : "/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        Path path = Paths.get("");
        try {
            FileUtils.copyFile(src,
                    new File(path.toAbsolutePath().toString()
                            + delimiter +"screenshots"
                            + delimiter + result.getTestClass().getName().replace(".", delimiter)
                            + delimiter + result.getMethod().getConstructorOrMethod().getName()
                            + ".png"
                             //test.java.test.ForPO
                    )
            );
        } catch (IOException err) {
            System.out.println(err);
        }
    }
}
