public class BullsAndCowsRunner {
    public static void main(String[] args) {
        // Выбираем имплиментацию игры, когда компьютер загадывает строку
        GameLogic gameLogic = new ComputerMakesStringGameLogicImpl();
        // Запускаем игру
        gameLogic.play();
    }
}