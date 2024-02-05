import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;

    public Game() {
        this.initializeGame();
    }

    private void initializeGame() {
        this.players = new LinkedList();
        this.board = new Board(10, 4, 4);
        this.dice = new Dice(1);
        this.addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("Farhan", 0);
        Player player2 = new Player("Ahmad", 0);
        this.players.addFirst(player2);
        this.players.addFirst(player1);
    }

    public void startGame() {
        System.out.println("Game Starts");

        Player playerTurn;
        int playerNewPosition;
        do {
            playerTurn = this.findPlayerTurn();
            System.out.println("Player : " + playerTurn.name + " turn from position : " + playerTurn.currentPosition);
            playerNewPosition = this.processJump(playerTurn.currentPosition + this.dice.rollDice());
            playerTurn.currentPosition = playerNewPosition;
            System.out.println("Player : " + playerTurn.name + " reached position : " + playerTurn.currentPosition);
        } while(playerNewPosition < this.board.cells.length * this.board.cells.length - 1);

        System.out.println("Winner is Player :" + playerTurn.name);
    }

    private Player findPlayerTurn() {
        Player player = (Player)this.players.getFirst();
        this.players.removeFirst();
        this.players.addLast(player);
        return player;
    }

    private int processJump(int playerNewPosition) {
        if (playerNewPosition >= this.board.cells.length * this.board.cells.length - 1) {
            return playerNewPosition;
        } else {
            Cell cell = this.board.getCell(playerNewPosition);
            if (cell.jump != null) {
                String jumpBy = cell.jump.startIndex < cell.jump.endIndex ? "ladder" : "snake";
                System.out.println("jump done by: " + jumpBy);
                return cell.jump.endIndex;
            } else {
                return playerNewPosition;
            }
        }
    }
}
