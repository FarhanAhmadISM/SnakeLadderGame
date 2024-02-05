import java.util.Random;

public class Player {
    int id;
    String name;
    int currentPosition;
    private static final Random random = new Random();

    public Player(String name, int currentPosition) {
        this.id = random.nextInt();
        this.name = name;
        this.currentPosition = currentPosition;
    }
}
