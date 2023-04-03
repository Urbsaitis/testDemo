package lt.tomas.pom.tests.demoQa;

import lt.tomas.pom.pages.demoQa.TextBoxPages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {


    @BeforeMethod
    public void setUp() {
        TextBoxPages.open();
    }

    @Test
    public void testFullNameInput_FullNameValueDailius() {

        String messageFullName = "Tomas Urbsaitis";
        String expectedResult = "Tomas Urbsaitis";
        String actualResult;

        TextBoxPages.enterFullName(messageFullName);
        TextBoxPages.clickOnButtonSubmit();
        actualResult = TextBoxPages.readFullNameMessage();

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

        TextBoxPages.enterEmailAdress(mesageEmail);
        TextBoxPages.clickOnButtonSubmit();
        actualResult = TextBoxPages.readEmailMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult));
    }

    @AfterMethod
    public void tearDown() {
        TextBoxPages.closeDriver();
    }
}
