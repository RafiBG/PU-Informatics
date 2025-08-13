public class Players {
    int player1Money = 1000;
    int player2Money = 1000;
    private int coins;
    private boolean trapSet;

    public Player(int coins) {
        this.coins = coins;
        trapSet = false;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isTrapSet() {
        return trapSet;
    }

    public void setTrap(boolean set) {
        trapSet = set;
    }
}
