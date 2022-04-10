import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int userInput (String message) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        while (true) {
            System.out.println(message);
            String input= scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else {
                value = Integer.parseInt(input);
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        int size = userInput("Введите размер списка: ");
        int limit = userInput("Введите верхнюю границу для значений: ");

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(limit));
        }

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filterLimit = userInput("Введите порог для фильтра: ");

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterLimit);
        List<Integer> filterList = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filterList.toString());

        logger.log("Завершаем программу");
    }
}
