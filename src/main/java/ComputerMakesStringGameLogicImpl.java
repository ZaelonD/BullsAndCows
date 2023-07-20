import java.util.*;

public class ComputerMakesStringGameLogicImpl implements GameLogic {
    private static final int DIGIT = 4;
    private int cows;
    private int bulls;
    private String randomNumber;

    @Override
    public void play() {
        generateRandomNumber();
        while (bulls != 4) {
            System.out.println(getRandomNumber());
        }
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

    public int getCows() {
        return cows;
    }

    public int getBulls() {
        return bulls;
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}
