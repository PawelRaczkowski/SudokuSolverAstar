package Board;

public class SudokuLine {
    private final static int NUMBER_OF_CELLS=9;
    private Cell[] cells;

    public SudokuLine()
    {
        cells=new Cell[NUMBER_OF_CELLS];
    }

    public Cell[] getCells() {
        return cells;
    }
}
