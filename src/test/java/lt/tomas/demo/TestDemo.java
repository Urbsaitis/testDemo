package lt.tomas.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {

    @Test
    public void testIfNumberIsEven_InputValueIs10() {
        // 1. duomenys
        int input = 10;
        int expectedReminder = 0;
        int actualReminder;

        // 2. testavimo veiksmai
        actualReminder = input % 2;

        // 3. testavimo rezutatu patikrinimas
        Assert.assertEquals(actualReminder, expectedReminder);
    }

    @Test
    public void testAssertFalseIfNumberIsNotEven_InputValueIs9() {
        // 1. duomenys
        int input = 9;
        int expectedReminder = 0;
        int actualReminder;

        // 2. testavimo veiksmai
        actualReminder = input % 2;

        // 3. testavimo rezutatu patikrinimas
        Assert.assertFalse(
                actualReminder == expectedReminder,
                String.format("Actual: %s, Expected: %s", actualReminder, expectedReminder)
        );
    }

    @Test
    public void testWithAssertTrueIfNumberIsNotEven_InputNumberIs9() {
        // 1. duomenys
        int input = 9;
        int expectedReminder = 1;
        int actualReminder;

        // 2. testavimo veiksmai
        actualReminder = input % 2;

        // 3. testavimo rezutatu patikrinimas
        Assert.assertTrue(
                actualReminder == expectedReminder,
                String.format("Actual: %s, Expected: %s", actualReminder, expectedReminder)
        );
    }

    @Test
    public void testIfSumIsCorrect_InputValuesIs5And6(){
        // 1. duomensy
        Integer inputA = 5;
        Integer inputB = 6;
        int expectedResult = 11;
        int actualResult;

        // 2. veiksmai
        actualResult = inputA + inputB;

        // 3. testas
//        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertTrue(
                actualResult == expectedResult,
                String.format("Actual: %s, Expected: %s", actualResult, expectedResult)
        );
    }
}
