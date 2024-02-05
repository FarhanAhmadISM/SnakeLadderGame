public class Board {
    Cell[][] cells;

    public Board(int cellSize, int noOfSnakes, int noOfLadders) {
        this.cells = new Cell[cellSize][cellSize];

        for(int i = 0; i < cellSize; ++i) {
            for(int j = 0; j < cellSize; ++j) {
                this.cells[i][j] = new Cell();
            }
        }

        this.addSnakesAndLadders(noOfSnakes, noOfLadders);
    }

    private void addSnakesAndLadders(int noOfSnakes, int noOfLadders) {
        int ladderStart;
        int ladderEnd;
        Jump ladderObj;
        Cell cell;
        while(noOfSnakes > 0) {
            ladderStart = (int)Math.round(Math.random() * 97.0 + 1.0);
            ladderEnd = (int)Math.round(Math.random() * 97.0 + 1.0);
            if (ladderEnd < ladderStart) {
                --noOfSnakes;
                ladderObj = new Jump(ladderStart, ladderEnd);
                cell = this.getCell(ladderStart);
                cell.jump = ladderObj;
            }
        }

        while(noOfLadders > 0) {
            ladderStart = (int)Math.round(Math.random() * 97.0 + 1.0);
            ladderEnd = (int)Math.round(Math.random() * 97.0 + 1.0);
            if (ladderEnd < ladderStart) {
                --noOfLadders;
                ladderObj = new Jump(ladderStart, ladderEnd);
                cell = this.getCell(ladderStart);
                cell.jump = ladderObj;
            }
        }

    }

    public Cell getCell(int position) {
        return this.cells[position / this.cells.length][position % this.cells.length];
    }
}