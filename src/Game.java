import graphics.GameGUI;

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

    GameGUI gameGUI;

    public Game() {
        gameBoard = new Board(3);

        gameInput = new Scanner(System.in);

        player1 = selectPlayer(1, 'x', gameBoard, "player 1");
        player2 = selectPlayer(2, 'o', gameBoard, "player 2");

        gameGUI = new GameGUI();

        mainLoop();

    }

    private Player selectPlayer(int playerNo, char piece, Board gameBoard, String name) {
        System.out.println("Please select the difficulty for player "+ playerNo + ":");
        System.out.println("1. Human");
        System.out.println("2. Easy");
        System.out.println("3. Medium");
        System.out.println("4. Hard");
        int choice = gameInput.nextInt();
        //System.out.println("Please enter a name for the player: ");
        //String name = gameInput.next();

        if (choice == 1) {
            return new HumanPlayer(name, piece, gameBoard);
        } else if (choice == 2) {
            return new RandomPlayer(name, piece, gameBoard);
        } else if (choice == 3) {
            return new MediumPlayer(name, piece, gameBoard);
        } else if (choice == 4) {
            return new MinMaxPlayer(name, piece, gameBoard);
        }

        return null;

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
            gameGUI.addPiece(pos, currentPlayer.getPiece());
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

        gameBoard.reset(3);
        gameGUI.reset();

        //mainLoop();
    }


}
