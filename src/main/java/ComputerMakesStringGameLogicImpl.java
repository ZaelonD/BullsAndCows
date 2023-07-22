import java.util.*;

public class ComputerMakesStringGameLogicImpl implements GameLogic {
    private final int DIGIT = 4;
    private int cows;
    private int bulls;
    private String randomNumber;
    private final ReadConsole console = new ReadConsole();
    private final PrintMessages message = new PrintMessages();
    private final WriteFile writeFile = new WriteFile();
    private final ReadFile readFile = new ReadFile();

    @Override
    public void play() {
        generateRandomNumber();
        writeFile.writeMessageToFile(message.startGame(randomNumber, readFile.numGame(writeFile.getFile())));
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
            writeFile.writeMessageToFile(message.requestResponseString(inputNumber, cows, bulls));
            System.out.println(message.requestResponseString(inputNumber, cows, bulls));
            count++;
        }
        console.getScanner().close();
        writeFile.writeMessageToFile(message.gameOver(count));
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