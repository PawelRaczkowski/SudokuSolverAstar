package Algorithm;

import Board.Column;
import Board.Row;
import Board.Square;
import Board.SudokuBoard;

public class State implements Evaluation {
    private double valueOfEvaluation; // odpowiednik kosztu
    private SudokuBoard currentSudokuBoard;

    public State(double valueOfEvaluation, SudokuBoard sudokuBoard)
    {
        this.valueOfEvaluation=valueOfEvaluation;
        currentSudokuBoard=sudokuBoard;
    }

    public SudokuBoard getCurrentSudokuBoard() {
        return currentSudokuBoard;
    }

    @Override
    public double evaluate() {
        double evaluation=0.0d;
        for(Square square : currentSudokuBoard.getSquareList()) // sprawdzamy każdy kwadrat czy są tam różnowartościowe liczby
        {
            if(square.checkCorrectness(square.getCells()))
                evaluation+=100;
            else
                evaluation+=currentSudokuBoard.calculatePartOfCorectness(square.getCells());
        }
        for(Row row: currentSudokuBoard.getRows()) // sprawdzamy każdy wiersz- jeżeli wiersz jest git to nagradzamy
        {
            if(currentSudokuBoard.checkLine(row))
                evaluation+=50;
            else
                evaluation+=currentSudokuBoard.calculatePartOfCorectness(row.getCells());
        }
        for(Column column : currentSudokuBoard.getColumns())
        {
            if(currentSudokuBoard.checkLine(column))
                evaluation+=50;
            else
                evaluation+=currentSudokuBoard.calculatePartOfCorectness(column.getCells());
        }
        valueOfEvaluation=evaluation;
        return valueOfEvaluation;
    }

    public boolean isTerminal() {
        for(Square square: currentSudokuBoard.getSquareList())
            if(!square.checkCorrectness(square.getCells()))
                return false;



        for(Row row:currentSudokuBoard.getRows())
            if(!currentSudokuBoard.checkLine(row))
                return false;



        for(Column column:currentSudokuBoard.getColumns())
            if(!currentSudokuBoard.checkLine(column))
                return false;

        return true;
    }
}
