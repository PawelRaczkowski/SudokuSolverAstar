package Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.company.Main.NUMBER_OF_CELLS;

public class Square extends CorrectMethods {
    private int id;
    private Cell [] cells;
    private List<Cell> unchangebleCells; // dane od początku nie mogą być zmieniane
    private List<Cell> changeableCells;

    Square(int id)
    {
        cells=new Cell[NUMBER_OF_CELLS];


        unchangebleCells=new ArrayList<>();
        changeableCells=new ArrayList<>();
        for(int i=0; i<cells.length;i++){
            cells[i]=new Cell(i);
            changeableCells.add(cells[i]);
        }
        this.id=id;
    }

    public Cell[] getCells() {
        return cells;
    }

    public void initializeValues(int number, int cellId) {
        cells[cellId].setNumber(number);
        unchangebleCells.add(cells[cellId]);
        changeableCells.remove(cells[cellId]);
    }

    public void printSquare() {
        int counter=0;
        for(Cell cell: cells)
        {
            if(counter%3==0)
                System.out.println();
            System.out.print(cell.getNumber() + " ");
            ++counter;
        }
    }
    public void printListOfCells()
    {
        System.out.println("Printing list of square number " + id + "...");
        System.out.println("Unchangeable cells:");
        unchangebleCells.stream().forEach(cell -> System.out.print(cell.getId() + " "));
        System.out.println("Changeable cells: ");
        changeableCells.stream().forEach(cell -> System.out.print(cell.getId() + " "));
    }

    /*public boolean checkCorrectness(Cell [] givenCells) { // sprawdza poprawność w obrębie kwadratu czy jakaś liczba się nie powtarza
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

    private boolean checkTheSameValue(Cell cell, LinkedList<Cell> checkedCells) {
        if(checkedCells.size()==0)
            return false;
        for(Cell c : checkedCells)
        {
            if(c.getNumber()==cell.getNumber())
                return true;
        }
        return false;
    }*/

//    public double calculatePartOfCorectness() {
//        double value=0.0d;
//        value+=checkUniquenessNumbers();
//        for(Cell cell : cells)
//        {
//            if(cell.getNumber()!=-1)
//                value+=5;
//        }
//        return value;
//    }
//
//    public double checkUniquenessNumbers() {
//        int counterOfUniqueNumbers=0;
//
//
//        LinkedList<Cell> checkedCells=new LinkedList<>();
//        LinkedList<Cell> uncheckedCells=new LinkedList<>(Arrays.asList(cells));
//
//        for(Cell cell : uncheckedCells)
//        {
//            if(!checkTheSameValue(cell,checkedCells)) {
//                counterOfUniqueNumbers += 1;
//                uncheckedCells.remove(cell);
//                checkedCells.add(cell);
//            }
//        }
//        return counterOfUniqueNumbers*5.0;
//    }
}
