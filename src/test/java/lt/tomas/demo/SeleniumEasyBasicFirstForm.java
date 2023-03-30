package lt.tomas.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumEasyBasicFirstForm {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("--force-device-scale-factor=0.7");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
    }


    @Test
    public void singleInputField() {

        String message = "Labas vakaras";
        String expectedResult = "Labas vakaras";
        String actualResult;

        WebElement inputmessage = driver.findElement(By.xpath("//input[@id='user-message']"));
        inputmessage.sendKeys(message);

        WebElement buttonSubmit = driver.findElement(By.xpath
                ("//button[@type='button' and @class='btn btn-default' and @onclick='showInput();']"));
        buttonSubmit.click();

        WebElement yourMessage = driver.findElement(By.xpath("//span[@id='display']"));
        actualResult = yourMessage.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult)
        );

    }

    @Test
    public void twoInputFieldsValid() {
        String enterA = "10";
        String enterB = "11";
        String expectedResult = "21";
        String actualResult;

        WebElement inputA = driver.findElement(By.xpath("//input[@id='sum1']"));
        inputA.sendKeys(enterA);

        WebElement inputB = driver.findElement(By.xpath("//input[@id='sum2']"));
        inputB.sendKeys(enterB);

        WebElement buttonGetTotal = driver.findElement(By.xpath
                ("//button[@onclick='return total()']"));
        buttonGetTotal.click();

        WebElement totalSum = driver.findElement(By.xpath("//span[@id='displayvalue']"));
        actualResult = totalSum.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult)
        );

    }


    @Test
    public void twoInputFieldsNotValid() {
        String enterA = "bb";
        String enterB = "11";
        String expectedResult = "NaN";
        String actualResult;

        WebElement inputA = driver.findElement(By.xpath("//input[@id='sum1']"));
        inputA.sendKeys(enterA);

        WebElement inputB = driver.findElement(By.xpath("//input[@id='sum2']"));
        inputB.sendKeys(enterB);

        WebElement buttonGetTotal = driver.findElement(By.xpath
                ("//button[@onclick='return total()']"));
        buttonGetTotal.click();

        WebElement totalSum = driver.findElement(By.xpath("//span[@id='displayvalue']"));
        actualResult = totalSum.getText();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult)
        );

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
