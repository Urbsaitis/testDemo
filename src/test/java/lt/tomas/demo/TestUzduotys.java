package lt.tomas.demo;



import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TestUzduotys {

    @Test
    public void testWeekOfDayIfTodayIsWednesday() {

        DayOfWeek expectedResult = DayOfWeek.MONDAY;
        DayOfWeek actualResult;

        actualResult = LocalDateTime.now().getDayOfWeek();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void activateSleepFor5Seconds(){

        try {
            System.out.println("Starting...");
            Thread.sleep(5000);
            System.out.println("FINALE");
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}