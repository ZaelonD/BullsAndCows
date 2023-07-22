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
        PrintMessages message = new PrintMessages();
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
            System.out.println(message.requestResponseString(inputNumber, cows, bulls));
            count++;
        }
        System.out.println(message.gameOver(count));
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
