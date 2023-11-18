import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) {
        WorkingHoursCalculator calculator = new WorkingHoursCalculator();
       
        WorkSchedule januarySchedule = new WorkSchedule();
        januarySchedule.setWorkHours(LocalTime.of(9, 0), LocalTime.of(17, 0));
        januarySchedule.addNonWorkingDay(LocalDate.of(2023, 1, 1)); 
        januarySchedule.addNonWorkingDay(LocalDate.of(2023, 1, 7));

        calculator.addWorkSchedule(1, januarySchedule); 

        LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 9, 0); 
        LocalDateTime endDateTime = LocalDateTime.of(2023, 1, 31, 17, 0); 

        long workingHours = calculator.calculateWorkingHours(startDateTime, endDateTime);
        System.out.println("Кількість робочих годин: " + workingHours);
    }
}

