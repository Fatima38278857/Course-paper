import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task implements Entry{ // Годовые задания

      public LocalDateTime appearsln;

    public YearlyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException {
        super(title, description, taskType, firstDate);
    }
    public boolean checkOccurance(LocalDate requestedDate){
        return getFirstDate().getDayOfYear() == (requestedDate.getDayOfYear());
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

