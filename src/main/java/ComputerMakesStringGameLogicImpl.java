import java.util.*;

public class ComputerMakesStringGameLogicImpl implements GameLogic {
    private final int DIGIT = 4;
    private int cows;
    private int bulls;
    private String randomNumber;

    @Override
    public void play() {
        generateRandomNumber();
        ReadConsole console = new ReadConsole();
        System.out.println(randomNumber);
        int count = 0;
        while (bulls != 4) {
            console.scanConsole(DIGIT);
            String inputNumber = console.getInputNumber();
            bulls = cows = 0;
            for (int i = 0; i < DIGIT; i++) {
                if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
                    bulls++;
                } else if (randomNumber.contains(String.valueOf(inputNumber.charAt(i)))) {
                    cows++;
                }
            }
            System.out.println("Запрос: " + inputNumber + " Ответ: " + cows + getCowsString() + bulls + getBullsString());
            count++;
        }
        System.out.println("Строка была угадана за " + count + " попыток.");
    }

    // Метод для получения строки коровы в правильном падеже
    private String getCowsString() {
        String cowsString;
        if (cows == 1) {
            cowsString = " корова ";
        } else if (cows == 0) {
            cowsString = " коров ";
        } else {
            cowsString = " коровы ";
        }
        return cowsString;
    }

    // Метод для получения строки быка в правильном падеже
    private String getBullsString() {
        String bullsString;
        if (bulls == 1) {
            bullsString = " бык ";
        } else if (bulls == 0) {
            bullsString = " быков ";
        } else {
            bullsString = " быка ";
        }
        return bullsString;
    }

    // Метод генерации строки случайных неповторяющихся цифр
    private void generateRandomNumber() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < DIGIT; i++) {
            number.append(nums.get(i));
        }
        randomNumber = number.toString();
    }
}
