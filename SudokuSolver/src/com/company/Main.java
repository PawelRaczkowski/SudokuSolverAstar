package com.company;

import Board.SudokuBoard;

public class Main {
    public final static int NUMBER_OF_CELLS=9;
    public static void main(String[] args) {
        SudokuBoard board=new SudokuBoard("C:\\Users\\Pawel\\Desktop\\SudokuBoard.txt");
        //board.printSudokuBoard();
        board.printData();
    }
}
