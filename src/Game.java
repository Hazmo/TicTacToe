import java.util.Scanner;

/**
 * Created by harry on 08/07/2015.
 */
public class Game {

    Board gameBoard;
    Player player1;
    Player player2;
    Player currentPlayer;

    Scanner gameInput;

    boolean isWinner = false;

    public Game() {
        gameBoard = new Board(3);

        player1 = new MinMaxPlayer("Human", 'x', gameBoard);
        player2 = new MinMaxPlayer("Random", 'o', gameBoard);

        gameInput = new Scanner(System.in);

        mainLoop();

    }

    public void mainLoop() {
        gameBoard.printBoard();

        for (int i = 1; i <= 9 && !isWinner; i++) {
            if(i % 2 != 0) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;


            }

            System.out.println(currentPlayer.getName() + " turn: ");


            int pos = currentPlayer.getMove();

            while(!gameBoard.move(pos, currentPlayer)) {
                System.out.println(currentPlayer.getName() + ", please choose another position" + " " + pos);
                pos = currentPlayer.getMove();
            }
            gameBoard.printBoard();

            isWinner = gameBoard.checkWinner();


        }
        if(isWinner) {
            winner(currentPlayer);
        } else {
            draw();
        }
    }

    public void winner(Player player) {
        System.out.println(player.getName() + " is the winner!");
        if (playAgain()) {
            restart();
        }
    }

    private void draw() {
        System.out.println("It's a draw!");
        if(playAgain()) {
            restart();
        }
    }

    private boolean playAgain() {
        System.out.println("Do you want to play again? (y/n)");
        String answer = gameInput.next();

        if(answer.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    private void restart() {
        //gameBoard = new Board(3, this);
        //isWinner = false;

        new Game();

        //mainLoop();
    }


}
