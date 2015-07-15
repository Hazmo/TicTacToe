/**
 * Created by harry on 08/07/2015.
 */
public abstract class Player {

    private String name;
    private char piece;
    private boolean isAI;

    public Player(String name, char piece) {
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
