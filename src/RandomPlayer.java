import java.util.Random;

/**
 * Created by harry on 09/07/2015.
 */
public class RandomPlayer extends AIPlayer {


    Random rng;

    public RandomPlayer(String name, char piece, Board gameBoard) {
        super(name, piece, gameBoard);
        rng = new Random();
    }


    @Override
    public int determineMove() {
        int pos = rng.nextInt(9) + 1;

        while(!gameBoard.isEmpty(pos)) {
            pos = rng.nextInt(9) + 1;
        }

        return pos;

    }

    @Override
    public int getMove() {
        return determineMove();
    }
}
