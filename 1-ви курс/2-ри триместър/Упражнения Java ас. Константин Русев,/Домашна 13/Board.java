import java.util.Random;
import java.util.HashSet;
import java.util.Set;
public class Board {
    private char[][] board;
    private int rows;
    private int columns;
    private Set<Integer> usedNumbers;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new char[rows][columns];
        this.usedNumbers = new HashSet<>();
    }

    public void generate() {
        Random random = new Random();
        int currentNumber = 2;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] != 'x' && board[i][j] != '#' && board[i][j] != '$' &&
                        board[i][j] != '%' && board[i][j] != '@') {
                    continue;
                }

                    int randomNumber;
                    do {
                        randomNumber = currentNumber;
                        currentNumber += 2;
                    } while (usedNumbers.contains(randomNumber));

                    usedNumbers.add(randomNumber);
                    board[i][j] = (char) ('0' + randomNumber);
                }
            }
        }

    public void placePlayer(Player player) {
        int i = randomEmptyRow();
        int j = randomEmptyColumn();
        board[i][j] = player.getSymbol();
        player.setPosition(i, j);
    }

    private int randomEmptyRow() {
        Random random = new Random();
        int i;
        do {
            i = random.nextInt(rows);
        } while (board[i][0] != '-');
        return i;
    }

    private int randomEmptyColumn() {
        Random random = new Random();
        int j;
        do {
            j = random.nextInt(columns);
        } while (board[0][j] != '-');
        return j;
    }
    public boolean movePlayer(Player player, MoveDirection direction) {
        int row = player.getRow();
        int column = player.getColumn();
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case UP:
                newRow = row - 1;
                break;
            case DOWN:
                newRow = row + 1;
                break;
            case LEFT:
                newColumn = column - 1;
                break;
            case RIGHT:
                newColumn = column + 1;
                break;
        }

        if (isValidMove(newRow, newColumn) && isGreaterThanNeighbors(newRow, newColumn)) {
            board[row][column] = '-';
            board[newRow][newColumn] = player.getSymbol();
            player.setPosition(newRow, newColumn);
            return true;
        }
        return false;
    }

    public boolean movePlayerEven(Player player, MoveDirection direction) {
        int row = player.getRow();
        int column = player.getColumn();
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case UP:
                newRow = row - 1;
                break;
            case DOWN:
                newRow = row + 1;
                break;
            case LEFT:
                newColumn = column - 1;
                break;
            case RIGHT:
                newColumn = column + 1;
                break;
        }

        if (isValidMove(newRow, newColumn) && isEven(board[newRow][newColumn])) {
            board[row][column] = '-';
            board[newRow][newColumn] = player.getSymbol();
            player.setPosition(newRow, newColumn);
            return true;
        }
        return false;
    }

    public boolean movePlayerDescending(Player player, MoveDirection direction) {
        int row = player.getRow();
        int column = player.getColumn();
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case UP:
                newRow = row - 1;
                break;
            case DOWN:
                newRow = row + 1;
                break;
            case LEFT:
                newColumn = column - 1;
                break;
            case RIGHT:
                newColumn = column + 1;
                break;
        }

        if (isValidMove(newRow, newColumn) && isDescendingOrder(newRow, newColumn)) {
            board[row][column] = '-';
            board[newRow][newColumn] = player.getSymbol();
            player.setPosition(newRow, newColumn);
            return true;
        }
        return false;
    }

    private boolean isValidMove(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns && board[row][column] != '-';
    }

    private boolean isGreaterThanNeighbors(int row, int column) {
        int count = 0;
        int sum = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && board[i][j] != '-') {
                    count++;
                    sum += Character.getNumericValue(board[i][j]);
                }
            }
        }

        int mean = count == 0 ? 0 : sum / count;
        return board[row][column] > mean;
    }

    private boolean isEven(char c) {
        int number = Character.getNumericValue(c);
        return number % 2 == 0;
    }

    private boolean isDescendingOrder(int row, int column) {
        int currentValue = Character.getNumericValue(board[row][column]);
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                break;
            }

            int previousValue = Character.getNumericValue(board[i][column]);
            if (currentValue <= previousValue) {
                return false;
            }
            currentValue = previousValue;
        }
        return true;
    }

    public boolean isPlayerAtX(Player player) {
        int row = player.getRow();
        int column = player.getColumn();
        return board[row][column] == 'x';
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

