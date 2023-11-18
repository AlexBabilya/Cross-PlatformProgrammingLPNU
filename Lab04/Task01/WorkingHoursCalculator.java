import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

public class WorkingHoursCalculator {

    HashMap<Integer, WorkSchedule> workSchedules = new HashMap<>();

    public void addWorkSchedule(int month, WorkSchedule workSchedule) {
        workSchedules.put(month, workSchedule);
    }

    public long calculateWorkingHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        long workingHours = 0;
        LocalDateTime current = startDateTime;

        while (current.isBefore(endDateTime)) {
            WorkSchedule workSchedule = workSchedules.get(current.getMonthValue());

            if (workSchedule.isWorkDay(current.toLocalDate())) {
                LocalDateTime workStart = current.with(LocalTime.of(workSchedule.getStartTime().getHour(), workSchedule.getStartTime().getMinute()));
                LocalDateTime workEnd = current.with(LocalTime.of(workSchedule.getEndTime().getHour(), workSchedule.getEndTime().getMinute()));

                if (workStart.isBefore(current) && workEnd.isAfter(current)) {
                    workingHours++;
                } else if (current.toLocalTime().isAfter(workSchedule.getStartTime()) && current.toLocalTime().isBefore(workSchedule.getEndTime())) {
                    workingHours++;
                }
            }
            current = current.plusHours(1);
        }
        return workingHours;
    }
}

