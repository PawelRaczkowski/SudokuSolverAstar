package Board;

public class Cell {
    private int id;
    private int number;

    Cell(int id)
    {
        this.id=id;
        this.number=-1;
    }
    public int getId(){ return id;}
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number=number;
    }


}
