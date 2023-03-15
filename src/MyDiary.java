import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Collections;

public class MyDiary { // МОЙ ЕЖЕДНЕВНИК


    static Map<Integer, Entry> actualTasks = new HashMap<>();

    public static void addTask(Scanner scanner) {

        try {
            scanner.nextLine();
            System.out.println("Введите название задачи: ");
            String title = CheckString.checkString(scanner.nextLine());
            System.out.println("Ввкдите описание задачи: ");
            String description = CheckString.checkString(scanner.nextLine());
            System.out.println("Ввыведите тип задачи: 0- Рабочая, 1- Личная");
            TaskType taskType = TaskType.values()[scanner.nextInt()];
            System.out.println("ведите тип значения: 0- Однократная, 1- Ежедневная, 2 - Еженедельная, 3- Ежемесячная, 4- Ежегодная");
            int occurance = scanner.nextInt();
            System.out.println("Введите дату dd.MM.yyyy HH:mm");
            scanner.nextLine();
            createEvent(scanner, title, description, taskType, occurance);
            System.out.println("Для выхода нажмите Enter\n");
            scanner.nextLine();
        } catch (StringException e) {
            System.out.println(e.getMessage());

        }
    }


    private static void createEvent(Scanner scanner, String title, String description, TaskType taskType, int occurance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Entry task = null;
            task = createTask(occurance, title, description, taskType, eventDate);
            System.out.println("Создана задача" + task);
        } catch (StringException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTask(Scanner scanner) {
        System.out.println("Текущие задачи\n");
        TaskService.printActualTask();
        try {
            System.out.println(" Для удоление задачи, напишите id задачи");
            int id = scanner.nextInt();
            if (actualTasks.containsKey(id)) {
                actualTasks.remove(id);
                System.out.println("Задача " + id + " удалена/n");
            } else {
                throw new RuntimeException();
            }

        } catch (RuntimeException e) {
            System.out.println("Такой задачи не существует");
        }
    }

    private static void getTaskByDate(Scanner scanner) {
        System.out.println("Введите дату как dd.MM.yyyy:");
        try {
            String date = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate requestedDate = LocalDate.parse(date, dateFormatter);
            List<Entry> foundEvents = findTaskByDate(requestedDate);
            System.out.println("События на " + requestedDate + ":");
            for (Entry task : foundEvents) {
                System.out.println(task);
            }

        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты dd.MM.yyyy попробуйте еще раз");
        }
        scanner.nextLine();
        System.out.println("Для выхода нажмите\n");
    }

    public static void getGroupedByDate() {
        Map<LocalDate, ArrayList<Entry>> taskMap = new HashMap<>();
        for (Map.Entry<Integer, Entry> entry : actualTasks.entrySet()) {
            Entry task = entry.getValue();
            LocalDate localDate = task.getFistDate().toLocalDate();
            if (taskMap.containsKey(localDate)) {
                ArrayList<Entry> tasks = taskMap.get(localDate);
                tasks.add(task);
            } else {
                taskMap.put(localDate, new ArrayList<>(Collections.singletonList(task)));
            }
        }
        for (Map.Entry<LocalDate, ArrayList<Entry>> taskEntry : taskMap.entrySet()) {
            System.out.println(taskEntry.getKey() + " : " + taskEntry.getValue());
        }


    }

    public static List<Entry> findTaskByDate(LocalDate date) {
        List<Entry> tasks = new ArrayList<>();
        for (Entry task : actualTasks.values()) {
            if (task.checkOccurance(date.atStartOfDay())) {
                tasks.add(task);
            }

            return tasks;
        }
    }


    private static Entry createTask(int occurance, String title, String description, TaskType taskType, LocalDateTime localDateTime) throws StringException {
             return switch (occurance) {
                 case 0 -> {
                     OneTimeTask oneTimeTask = new OneTimeTask(title, description, taskType, localDateTime) {
                     actualTasks.put(oneTimeTask.getid(), oneTimeTask);
                     yield oneTimeTask;
                }
                case 1 -> {
                    DailyTask task = new DailyTask(title, description, taskType, localDateTime) {
                     actualTasks.put(task.getid(),task);
                     yield task;
                    }
                    case 2 -> {
                        WeeklyTask task = new WeeklyTask(title, description, taskType, localDateTime) {
                            actualTasks.put(task.getid(), task);
                            yield task;
                        }
                        case 3 -> {
                            MonthlyTask task = new MonthlyTask(title, description, taskType, localDateTime) {
                                actualTasks.put(onceleTask.getid(), task);
                                yield task;
                            }
                            case 4 -> {
                                YearlyTask task 3= new YearlyTask(title, description, taskType, localDateTime) {
                                    actualTasks.put(onceleTask.getid(), (task);
                                    yield task;
                                }
                                  befault -> null;
                            }
                        }
                        private static void printActualTasks() {
                            for (Entry task : actualTasks.values()) {
                                System.out.println(task);
                            }
                        }
                    }