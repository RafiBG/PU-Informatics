public class BoardGame {
    private static final int BOARD_SIZE = 20;
    private char[][] board;

    public BoardGame() {
        board = new char[][] {
                {'|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|'},
                {'|', 'X', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', 'X', '|'},
                {'|', 'X', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', 'X', '|'},
                {'|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'X', '|', '|', 'S', '|', '|', 'X', '|'},
        };
    }

    public void displayBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }
}
