public class Player {

    private char symbol;
    private int row;
    private int column;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

