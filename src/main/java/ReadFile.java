import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    // Метод чтения файла
    public int numGame(File file) {
        int numNext;
        if (file.length() == 0) {
            numNext = 1;
        } else {
            List<String> games = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    if (scanner.next().contains("Game")) {
                        games.add(scanner.next());
                    }
                    scanner.nextLine();
                }
                scanner.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            numNext = numberNewGame(games);
        }
        return numNext;
    }

    // Метод получения следующей игры
    private int numberNewGame(List<String> games) {
        StringBuilder num = new StringBuilder();
        String game = games.get(games.size() - 1);
        for (int i = 1; i < game.length(); i++) {
            num.append(game.charAt(i));
        }
        return Integer.parseInt(num.toString()) + 1;
    }
}