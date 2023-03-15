import java.util.Scanner;




public class Main {
    public static void main(String[] args) {



        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                System.out.println("Введите пункт меню:");
                 printMenu();
                if (scanner.hasNextInt()) ;
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        MyDiary.addTask(scanner); // Заголовок
                        break;
                    case 2:

                        break;
                    case 3:
                        MyDiary.deleteTask(scanner); // Удоление
                        break;
                    case 0:
                        break label;
                }
            }

        }
    }

                    private static void printMenu() {
                        System.out.println("""
                    1. Добавить задачу
                    2. Получить задачу
                    3. Удалять задачу""");
                    }
}
