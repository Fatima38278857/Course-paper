import java.time.LocalDateTime;

public interface Entry { // Вхождение задачи

    boolean checkOccurance(LocalDateTime localDateTime);

    void setTitile(String titile);

    LocalDateTime getFistDate();



}
