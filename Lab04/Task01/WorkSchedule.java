import java.util.HashMap;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class WorkSchedule {
    private LocalTime startTime;
    private LocalTime endTime;
    private HashMap<LocalDate, Boolean> nonWorkingDays = new HashMap<>();

    public void setWorkHours(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void addNonWorkingDay(LocalDate date) {
        nonWorkingDays.put(date, true);
    }

    public boolean isWorkDay(LocalDate date) {
        if (nonWorkingDays.containsKey(date)) {
            return false;
        }
        return date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}

