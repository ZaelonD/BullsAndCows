import java.util.*;

public class ReadConsole {
    private final Scanner scanner = new Scanner(System.in);
    private String inputNumber;


    // Метод считывания с консоли и проверка на валидность
    public void scanConsole(int digit) {
        do {
            System.out.println("Введите число из неповторяющихся цифр");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число из неповторяющихся цифр");
                scanner.next();
            }
            inputNumber = scanner.next();
        } while (inputNumber.length() != digit || !isNotDuplicates(inputNumber, digit));
    }

    // Проверка на дублирующиеся цифры
    private boolean isNotDuplicates(String number, int digit) {
        boolean result = false;
        Set<Character> nums = new HashSet<>();
        if (number.length() == digit) {
            for (int i = 0; i < digit; i++) {
                nums.add(number.charAt(i));
            }
        }
        if (nums.size() == digit) {
            result = true;
        }
        return result;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
