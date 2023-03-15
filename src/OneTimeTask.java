import java.time.LocalDateTime;

public  class OneTimeTask  extends Task implements Entry{ // Одноразовые задания
    public LocalDateTime appearsln;

    public OneTimeTask(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException {
        super(title, description, taskType, firstDate);
    }

    public boolean checkOccurance(LocalDateTime requestedDate) {
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
