import java.time.LocalDate;
import java.time.LocalDateTime;

public  class DailyTask  extends Task implements Entry { // Ежедневные задачи

    public LocalDateTime appearsln;

    public DailyTask(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException {
        super(title, description, taskType, firstDate);
    }


    public boolean checkOccurance(LocalDate requestedDate) {
        return false;
    }

    public boolean checkOccurance(LocalDateTime requestedDate){
        return getFirstDate().toLocalDate().equals(requestedDate.toLocalDate());
}

    @Override
    public void setTitile(String titile) {

    }

    @Override
    public LocalDateTime getFistDate() {
        return null;
    }
}
