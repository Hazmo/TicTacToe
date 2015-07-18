import java.util.ArrayList;

/**
 * Created by harry on 14/07/2015.
 */
public class Node {

    Board board;
    private ArrayList<Node> children;
    int score;

    int move;

    public Node(Board board, int move) {
        this.board = board;
        children = new ArrayList<Node>();
        this.move = move;

    }

    public int getMove() {
        return move;
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void appendChild(Node newNode) {
        children.add(newNode);
    }

    public boolean isLeaf() {
        if (children.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
