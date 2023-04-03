package lt.tomas.pom.pages.demoQa;

import lt.tomas.pom.pages.Common;
import org.openqa.selenium.By;

import javax.sql.CommonDataSource;

public class TextBoxPages {

    public static void open() {

        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/text-box");
    }

    public static void closeDriver() {
        Common.closeDriver();
    }

    public static void enterFullName(String text) {

        Common.sendKeysToElement(
                By.xpath("//input[@id='userName']"),
                text
        );

    }

    public static void clickOnButtonSubmit() {

        Common.clickOnElement(By.xpath("//button[@id='submit']"));
    }

    public static String readFullNameMessage() {

        return Common.getTextFromElement(By.xpath("//p[@id='name']"));
    }

    public static void enterEmailAdress(String email) {


        Common.sendKeysToElement(
                By.xpath("//input[@id='userEmail']"),
                email
        );

    }
    public static String readEmailMessage() {

        return Common.getTextFromElement(By.xpath("//p[@id='email']"));
    }
}
