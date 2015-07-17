import java.util.ArrayList;
import java.util.Random;

/**
 * Created by harry on 17/07/2015.
 */
public class MediumPlayer extends Player {


    private int lastMove;
    private Random rng;
    private ArrayList<Integer> playerPotentialMoves;

    public MediumPlayer(String name, char piece, Board gameBoard) {
        super(name, piece, gameBoard);

        lastMove = -1;
        rng = new Random();
        playerPotentialMoves = new ArrayList<>();
    }

    @Override
    public int getMove() {

        ArrayList<Integer> boardPotentialMoves = gameBoard.getAvailableMoves();
        int move;

        if(lastMove != -1) {
            for (int i = -4; i < 4; i++) {
                playerPotentialMoves.add(lastMove + i);
            }
            boardPotentialMoves.retainAll(playerPotentialMoves);
        }
        int index = rng.nextInt(boardPotentialMoves.size());
        move = boardPotentialMoves.get(index);
        lastMove = move;
        return move;
    }
}
