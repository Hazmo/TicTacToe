import java.util.Scanner;

/**
 * Created by harry on 09/07/2015.
 */
public class HumanPlayer extends Player {

    Scanner playerInput;


    public HumanPlayer(String name, char piece) {
        super(name, piece);
        playerInput = new Scanner(System.in);
    }

    @Override
    public int getMove() {
        return playerInput.nextInt();
    }
}
