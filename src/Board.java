import java.util.ArrayList;
import java.util.List;

/**
 * Created by harry on 08/07/2015.
 */
public class Board {

    private char gameBoardArray[][];

    public Board(int size) {
        gameBoardArray = new char[size][size];

        for (int i = 0; i < gameBoardArray.length; i++) {
            for (int j = 0; j < gameBoardArray[i].length; j++) {
                gameBoardArray[i][j] = '-';
            }

        }
    }

    public Board(char[][] gameBoardArray) {
        this.gameBoardArray = gameBoardArray;
    }

    public void printBoard() {
        for (char row[] : gameBoardArray) {
            for(char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public boolean move(int pos, Player player) {

        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        if(gameBoardArray[row][col] != '-' || pos < 1 || pos > 9) {
            return false;
        } else {
            gameBoardArray[row][col] = player.getPiece();
        }

        return true;
    }

    public boolean move(int pos, char piece) {

        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        if(gameBoardArray[row][col] != '-' || pos < 1 || pos > 9) {
            return false;
        } else {
            gameBoardArray[row][col] = piece;
        }

        return true;
    }

    private boolean checkRows() {
        for (int i = 0; i < gameBoardArray.length; i++) {
            if(checkRowCol(gameBoardArray[i][0], gameBoardArray[i][1], gameBoardArray[i][2])) {
                return true;
            }

        }
        return false;
    }
    private boolean checkCols() {
        for (int i = 0; i < gameBoardArray.length; i++) {
            if(checkRowCol(gameBoardArray[0][i], gameBoardArray[1][i], gameBoardArray[2][i])) {
                return true;
            }
        }
        return false;
    }
    private boolean checkDiags() {
        if (checkRowCol(gameBoardArray[0][0],gameBoardArray[1][1],gameBoardArray[2][2]) || checkRowCol(gameBoardArray[0][2], gameBoardArray[1][1], gameBoardArray[2][0])) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkWinner() {
        if (checkCols() || checkRows() || checkDiags()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRowCol(char a, char b, char c) {
        if ((a != '-') && (a == b) && (b == c)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(int pos) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        if(gameBoardArray[row][col] == '-') {
            return true;
        } else {
            return false;
        }
    }

    public char[][] getBoardArray() {
        return gameBoardArray;
    }

    public char[][] copyBoardArray() {
        char[][] gameBoardArrayCopy = new char[3][3];


        for (int i = 0; i < gameBoardArray.length; i++) {
            for (int j = 0; j < gameBoardArray.length; j++) {
                gameBoardArrayCopy[i][j] = gameBoardArray[i][j];
            }
        }

        return gameBoardArrayCopy;
    }

    public ArrayList<Integer> getAvailableMoves() {
        ArrayList<Integer> availableMoves = new ArrayList<Integer>();

        for (int i = 0; i < gameBoardArray.length; i++) {
            for (int j = 0; j < gameBoardArray[i].length; j++) {
                if(gameBoardArray[i][j] == '-') {
                    int pos = (3 * i + 1) + j;
                    availableMoves.add(pos);
                }
            }

        }
        return availableMoves;
    }

}
