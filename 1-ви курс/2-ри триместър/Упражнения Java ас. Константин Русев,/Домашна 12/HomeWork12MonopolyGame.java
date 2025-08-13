import java.util.Random;

public class HomeWork12MonopolyGame {
    public static void main(String[] args) {
        BoardGame board = new BoardGame();
        Players humanPlayer = new Players();
        Players botPlayer = new Players();
        Random random = new Random();


        int turnCount = 0;
        boolean gameEnd = false;
        while (!gameEnd) {
            turnCount++;
            System.out.println("Turn " + turnCount);

            // Human player's turn
            int diceRoll = random.nextInt(1,3);
            System.out.println("Human player rolls the dice and moves " + diceRoll + " squares.");
            int humanPosition = humanPlayer.getPosition();
            int newHumanPosition = (humanPosition + diceRoll) % board.getBoardSize();
            humanPlayer.setPosition(newHumanPosition);
            System.out.println("Human player moves to square " + (newHumanPosition + 1) + ".");

            // Bot player's turn
            diceRoll = random.nextInt(1,3);
            System.out.println("Bot player rolls the dice and moves " + diceRoll + " squares.");
            int botPosition = botPlayer.getPosition();

            StartSquars startSquare = new StartSquars('S', 10);

            char symbol = startSquare.getSymbol();  // Returns 'S'
            int rations = startSquare.getRations();

            PartySquare partySquare = new PartySquare('P', 25);
            symbol = partySquare.getSymbol();
            int coinsToDeduct = partySquare.getCoinsToDeduct();
        }
    }
}
