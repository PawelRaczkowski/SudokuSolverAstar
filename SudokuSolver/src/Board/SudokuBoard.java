package Board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static com.company.Main.NUMBER_OF_CELLS;

public class SudokuBoard extends CorrectMethods {
    private Square[] squareList; // constant length of array
    private Row[] rows;
    private Column[] columns;

    public SudokuBoard(String filePath)
    {
        squareList=new Square[NUMBER_OF_CELLS];
        rows=new Row[NUMBER_OF_CELLS];
        columns=new Column[NUMBER_OF_CELLS];
        for(int i=0; i<NUMBER_OF_CELLS;i++)
        {
            squareList[i]=new Square(i);
            rows[i]=new Row();
            columns[i]= new Column();
        }
        initValues(squareList, filePath);
        constructRowsAndColumns();

    }

    private void constructRowsAndColumns() {
        // tworzenie wierszy
        int noRow=0;
        int noSquare=0;
        int noCellInRow=0;


        while(noRow<NUMBER_OF_CELLS)
        {
            for(int j=0;j<3;j++) {
                for (int i = 0; i < 3; i++) {
                    rows[noRow].getCells()[noCellInRow] = squareList[noSquare].getCells()[(noRow % 3) * 3 + i];
                    ++noCellInRow;
                }
                ++noSquare;
            }
            ++noRow;
            noCellInRow=0;
            noSquare=0;
        }
        // tworzenie kolumn
        int noColumn=0;
        while(noColumn<NUMBER_OF_CELLS)
        {
            for(int j=0;j<3;j++) {
                for (int i = 0; i < 3; i++) {
                    columns[noColumn].getCells()[noCellInRow] = squareList[noSquare].getCells()[i*3+j];
                    ++noCellInRow;
                }
                noSquare+=3;
            }
            ++noColumn;
            noCellInRow=0;
            noSquare=0;
        }
    }



    private void initValues(Square[] squareList, String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                String [] data=line.split(" ");
                int squareId=Integer.parseInt(data[0]);
                int cellId=Integer.parseInt(data[1]);
                int number=Integer.parseInt(data[2]);
                if(!checkCorrectnessOfNumber(number))
                {
                    throw new ArithmeticException("Too big number for sudoku");
                }
                squareList[squareId].initializeValues(number, cellId);
            }
        }
        catch(IOException io)
        {
            System.out.println("Unfortunately, IOException");
            System.exit(123);
        }
        catch(IndexOutOfBoundsException be)
        {
            System.out.println("IndexOutOfBoundsException");
            System.exit(420);
        }
        catch(ArithmeticException ex)
        {
            System.out.println("Wrong value");
            System.exit(69);
        }
    }

    private boolean checkCorrectnessOfNumber(int number) {
        return number>=1 && number<=9 ? true : false;
    }

    public Square[] getSquareList() {
        return squareList;
    }

    public Row[] getRows() {
        return rows;
    }

    public Column[] getColumns() {
        return columns;
    }



    public boolean checkLine(SudokuLine line) {
        if(checkCorrectness(line.getCells()))
            return true;
        else
            return false;
    }



    public void printSudokuBoard()
    {
        for(Square square : squareList)
        {
            square.printSquare();
            System.out.println();
        }
    }
    public void printData()
    {
        Arrays.stream(squareList).forEach(square -> square.printListOfCells());
    }


}
