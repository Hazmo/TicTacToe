import java.util.ArrayList;
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
        ArrayList<Integer> availableMoves = gameBoard.getAvailableMoves();
        int index = rng.nextInt(availableMoves.size());

        return availableMoves.get(index);
    }
}
