package quack.models;

public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position() {
        this(0, 0);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Position translateUp() {
        Position position = new Position(getRow() - 1, getCol());
        return position;
    }

    public Position translateDown() {
        Position position = new Position(getRow() + 1, getCol());
        return position;
    }

    public Position translateLeft() {
        Position position = new Position(getRow(), getCol() - 1);
        return position;
    }

    public Position translateRight() {
        Position position = new Position(getRow(), getCol() + 1);
        return position;
    }
}
