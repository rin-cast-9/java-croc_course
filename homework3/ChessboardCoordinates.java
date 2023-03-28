public class ChessboardCoordinates {

    // this class represents coordinate system that's of a chessboard
    // that has on the one side values from 'a' to 'h' and on the other side values from 1 to 8

    private int x = 0; // x coordinate on a chessboard 
    private int y = 0; // y coordinate on a chessboard

    ChessboardCoordinates () { // empty constructor
    }

    ChessboardCoordinates (int x, int y) throws IllegalArgumentException { // constructor that sets coordianates to fields
        if (((x >= 0) && (x <= 7)) || ((y >= 0) && (y <= 7))) {
            this.x = x;
            this.y = y;
        }
        else {
            throw new IllegalArgumentException("Passed coordiantes are out of bounds"); // throws exception if passed coordiantes are out of bounds
        }
    }

    public void setX (int x) throws IllegalArgumentException { // x field setter
        if ((x >= 0) && (x <= 7)) {
            this.x = x;
        }
        else {
            throw new IllegalArgumentException("Passed x coordinate is out of bounds"); // throws exception if passed x value is out of bounds
        }
    }

    public int getX () { // x field getter
        return this.x;
    }

    public void setY (int y) throws IllegalArgumentException { // y field setter
        if ((y >= 0) && (y <= 7)) {
            this.y = y;
        }
        else {
            throw new IllegalArgumentException("Passed y coordinate is out of bounds"); // throws exception if passed y value is out of bounds
        }
    }

    public int getY () { // y field getter
        return this.y;
    }

    @Override
    public String toString() { // overriding toString() method to match this class implementation 
        char chessboardX = 'a'; // adding to 'a' values from 0 to 7 gives us all the chars from 'a' to 'h' 
        int chessboardY = 1; // shifting all the values allowed in the class (i.e. 0 to 7) by 1 gives us a range 1 to 8
        return String.format("%c%d", chessboardX + getX(), chessboardY + getY());
    }

}