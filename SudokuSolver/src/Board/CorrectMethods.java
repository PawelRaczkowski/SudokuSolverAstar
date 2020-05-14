package Board;

import java.util.Arrays;
import java.util.LinkedList;

public class CorrectMethods {
    public boolean checkCorrectness(Cell [] givenCells) { // sprawdza poprawność w obrębie kwadratu czy jakaś liczba się nie powtarza
        LinkedList<Cell> checkedCells=new LinkedList<>();
        LinkedList<Cell> uncheckedCells=new LinkedList<>(Arrays.asList(givenCells));

        for(Cell cell : uncheckedCells)
        {
            if(checkTheSameValue(cell, checkedCells))
                return false;
            else {
                checkedCells.add(cell);
                uncheckedCells.remove(cell);
            }
        }
        return true;
    }

    public boolean checkTheSameValue(Cell cell, LinkedList<Cell> checkedCells) {
        if(checkedCells.size()==0)
            return false;
        for(Cell c : checkedCells)
        {
            if(c.getNumber()==cell.getNumber())
                return true;
        }
        return false;
    }


    public double calculatePartOfCorectness(Cell[] cells) {
        double value=0.0d;
        value+=checkUniquenessNumbers(cells);
        for(Cell cell : cells)
        {
            if(cell.getNumber()!=-1)
                value+=5;
        }
        return value;
    }

    public double checkUniquenessNumbers(Cell [] cells) {
        int counterOfUniqueNumbers=0;


        LinkedList<Cell> checkedCells=new LinkedList<>();
        LinkedList<Cell> uncheckedCells=new LinkedList<>(Arrays.asList(cells));

        for(Cell cell : uncheckedCells)
        {
            if(!checkTheSameValue(cell,checkedCells)) {
                counterOfUniqueNumbers += 1;
                uncheckedCells.remove(cell);
                checkedCells.add(cell);
            }
        }
        return counterOfUniqueNumbers*5.0;
    }

}
