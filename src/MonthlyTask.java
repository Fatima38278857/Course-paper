import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask  extends Task implements Entry{ // Ежемесячные задачи

    public LocalDateTime appearsln;

    public MonthlyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException {
        super(title, description, taskType, firstDate);
    }

    public boolean checkOccurance(LocalDate requestedDate){
        return getFirstDate().getDayOfMonth() == (requestedDate.getDayOfMonth());
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
