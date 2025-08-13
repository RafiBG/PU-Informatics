import java.util.Random;
import java.util.HashSet;
import java.util.Set;
public class Game {
    private Board gameBoard;
    private Player player1;
    private Player player2;
    private Player player3;
    private int maxMoves;

    public Game(int rows, int columns, int maxMoves) {
        this.gameBoard = new Game(rows, columns);
        this.player1 = new Player("Играч 1", '$');
        this.player2 = new Player("Играч 2", '#');
        this.player3 = new Player("Играч 3", '%');
        this.maxMoves = maxMoves;
    }

    public void initialize() {
        gameBoard.generate();
        gameBoard.placePlayer(player1);
        gameBoard.placePlayer(player2);
        gameBoard.placePlayer(player3);
        gameBoard.printBoard();
    }

    public void play() {
        boolean gameEnded = false;
        int moves = 0;

        while (!gameEnded && moves < maxMoves) {
            boolean moved1 = gameBoard.movePlayer(player1, MoveDirection.RIGHT);
            if (moved1) {
                System.out.println("Играч 1 се предвижи.");
            } else {
                System.out.println("Играч 1 не може да се предвижи.");
            }

            boolean moved2 = gameBoard.movePlayerEven(player2, MoveDirection.RIGHT);
            if (moved2) {
                System.out.println("Играч 2 се предвижи.");
            } else {
                System.out.println("Играч 2 не може да се предвижи.");
            }

            boolean moved3 = gameBoard.movePlayerDescending(player3, MoveDirection.RIGHT);
            if (moved3) {
                System.out.println("Играч 3 се предвижи.");
            } else {
                System.out.println("Играч 3 не може да се предвижи.");
            }

            gameBoard.printBoard();

            if (gameBoard.isPlayerAtX(player1)) {
                System.out.println("Играч 1 спечели!");
                gameEnded = true;
            } else if (gameBoard.isPlayerAtX(player2)) {
                System.out.println("Играч 2 спечели!");
                gameEnded = true;
            } else if (gameBoard.isPlayerAtX(player3)) {
                System.out.println("Играч 3 спечели!");
                gameEnded = true;
            }
            moves++;
        }

        if (!gameEnded) {
            System.out.println("Играта приключи с равенство.");
        }
    }
}
