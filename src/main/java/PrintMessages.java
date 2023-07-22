import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintMessages {

    // Метод для получения строки попыток в правильном падеже
    private String tryString(int count) {
        String result = " ";
        if (count > 4 && count < 21) {
            result = " попыток.";
        } else if (count % 10 == 1) {
            result = " попытку.";
        } else if (count % 10 == 2 || count % 10 == 3 || count % 10 == 4) {
            result = " попытки. ";
        }
        return result;
    }

    // Метод для получения строки коровы в правильном падеже
    private String getCowsString(int cows) {
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
    private String getBullsString(int bulls) {
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

    public String requestResponseString(String inputNumber, int cows, int bulls) {
        return "Запрос: " + inputNumber + " Ответ: " + cows + getCowsString(cows) + bulls + getBullsString(bulls);
    }

    public String gameOver(int count) {
        return "Строка была угадана за " + count + tryString(count);
    }

    public String startGame(String randomNumber, int numGame) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyy HH:mm");
        return "Game №" + numGame + " " + dateFormat.format(new Date()) + " Загаданная строка " + randomNumber;
    }
}