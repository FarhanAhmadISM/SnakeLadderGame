public class Dice {
    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    int rollDice() {
        double random = Math.random() * (double)(this.max - this.min + 1) + (double)this.min;
        return (int)Math.round(random);
    }
}
