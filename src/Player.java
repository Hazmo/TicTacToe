/**
 * Created by harry on 08/07/2015.
 */
public abstract class Player {

    protected String name;
    protected char piece;
    protected Board gameBoard;

    public Player(String name, char piece, Board gameBoard) {
        this.name = name;
        this.piece = piece;
    }

    public char getPiece() {
        return piece;
    }

    public String getName() {
        return name;

    }

    public abstract int getMove();
}
