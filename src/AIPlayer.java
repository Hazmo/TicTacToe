/**
 * Created by harry on 08/07/2015.
 */
public abstract class AIPlayer extends Player {

    Board gameBoard;

    public AIPlayer(String name, char piece, Board gameBoard) {
        super(name, piece);
        this.gameBoard = gameBoard;
    }

    public abstract int determineMove();
}
