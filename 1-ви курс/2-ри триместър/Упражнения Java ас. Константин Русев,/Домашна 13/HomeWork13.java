

public class HomeWork13 {
    public static void main(String[] args) {
        int rows = 18;
        int columns = 12;
        int maxMoves = 15;

        Game game = new Game(rows, columns, maxMoves);
        game.initialize();
        game.play();
    }
}