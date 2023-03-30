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

public class TestSeleniumDemo {

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
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void seleniumDemo() {

    }

    @Test
    public void testFullNameInput_FullNameValueDailius() {

        String messageFullName = "Tomas Urbsaitis";
        String expectedResult = "Tomas Urbsaitis";
        String actualResult;

        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='userName']"));
        inputUserName.sendKeys(messageFullName);

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();

        WebElement paragraphName = driver.findElement(By.xpath("//p[@id='name']"));
        actualResult = paragraphName.getText(); // Name:Dailius Rascius

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult)
        );
    }

    @Test
    public void testEmailInput_WithvalidEmail() {

        String mesageEmail = "t.urbsaitis@gmail.com";
        String expectedResult = "t.urbsaitis@gmail.com";
        String actualResult;

        WebElement inputUserEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        inputUserEmail.sendKeys(mesageEmail);

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();

        WebElement paragraphUserEmail = driver.findElement(By.xpath("//p[@id='email']"));
        actualResult = paragraphUserEmail.getText();








        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
