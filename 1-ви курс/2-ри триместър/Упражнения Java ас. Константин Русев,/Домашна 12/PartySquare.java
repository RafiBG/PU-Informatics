public class PartySquare {
    private final int coinsToDeduct;

    public PartySquare(char symbol, int coinsToDeduct) {
        super(symbol);
        this.coinsToDeduct = coinsToDeduct;
    }

    public int getCoinsToDeduct() {
        return coinsToDeduct;
    }
}
