import java.util.Random;

/**
 * Created by harry on 09/07/2015.
 */
public class RandomPlayer extends Player {


    Random rng;

    public RandomPlayer(String name, char piece, Board gameBoard) {
        super(name, piece, gameBoard);
        rng = new Random();
    }

    @Override
    public int getMove() {
        int pos = rng.nextInt(9) + 1;

        while(!gameBoard.isEmpty(pos)) {
            pos = rng.nextInt(9) + 1;
        }

        return pos;
    }
}
