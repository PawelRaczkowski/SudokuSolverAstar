package Algorithm;

import Board.SudokuBoard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgorithmAstar {
    private static State start;
    private State currentState;
    private List<State> Gset;
    private List<State> Pset;
    private static int iterator;

    public AlgorithmAstar(State start) {
        this.start = start;
        this.currentState = start;
        Gset=new LinkedList<>();
        Pset=new LinkedList<>();
        iterator=0;
    }

    public State getStart() {
        return start;
    }

    public void setStart(State start) {
        this.start = start;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public  State execute()
    {
        State theBestState = start;
        while(!currentState.isTerminal()) {
            //TODO: IMPLEMENTACJA ALGORYTMU A*

        }
        return theBestState;
    }
}
