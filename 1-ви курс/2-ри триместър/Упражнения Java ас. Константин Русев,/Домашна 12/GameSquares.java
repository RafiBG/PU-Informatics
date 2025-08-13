public class GameSquares {
    private char symbol;

    public void GameSquare(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

public class StartSquars {
    private int rations;

    public StartSquars(char symbol, int rations) {
        super(symbol);
        this.rations = rations;
    }

    public int getRations() {
        return rations;
    }

    public void setRations(int rations) {
        this.rations = rations;
    }

    public char getSymbol() {
        return 0;
    }
}
