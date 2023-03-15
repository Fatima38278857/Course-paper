import java.time.LocalDate;
import java.time.LocalDateTime;

public  class WeeklyTask extends Task implements Entry { // Еженедельные задачи
    public LocalDateTime appearsln;

    public WeeklyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException {
        super(title, description, taskType, firstDate);
    }

    public boolean checkOccurance(LocalDate requestedDate) {
        return getFirstDate().getDayOfWeek().equals(requestedDate.getDayOfWeek());
    }

    @Override
    public boolean checkOccurance(LocalDateTime localDateTime) {
        return false;
    }

    @Override
    public void setTitile(String titile) {

    }

    @Override
    public LocalDateTime getFistDate() {
        return null;
    }
}
