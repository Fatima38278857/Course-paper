import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task { // ЗАДАЧИ


    private String title;
    private String description;
    private TaskType taskType;
    private LocalDateTime firstDate;
    private static Integer counter = 1;
    private final Integer  id;


    public Task(String title, String description, TaskType taskType, LocalDateTime firstDate) throws StringException{
        this.title = CheckString.checkString(title);
        this.description = CheckString.checkString(description);
        this.taskType = taskType;
        this.firstDate = firstDate;
        id = counter++;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public LocalDateTime getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDateTime firstDate) {
        this.firstDate = firstDate;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Task.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return title.equals(task.title) && description.equals(task.description) && taskType == task.taskType && firstDate.equals(task.firstDate) && id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, taskType, firstDate, id);
    }

    @Override
    public String toString() {
        return "Task-" + "Заголовак -" + title + '\'' + ", Описание -" + description + '\'' + ", Тип задачи -" + taskType + ", Первый день -" + firstDate + ", id - " + id + '}';
    }

}
