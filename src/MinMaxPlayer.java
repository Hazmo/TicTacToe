/**
 * Created by harry on 09/07/2015.
 */
public class MinMaxPlayer extends Player{

    Node root;
    char playerPiece;
    char opponentPiece;

    public MinMaxPlayer(String name, char piece, Board gameBoard) {
        super(name, piece, gameBoard);

        playerPiece = piece;

        if(playerPiece == 'x') {
            opponentPiece = 'o';
        } else {
            opponentPiece = 'x';
        }
    }

    private int getMoveFromMinMaxTree(Node root) {
        int maxScore = Integer.MIN_VALUE;
        Node maxNode = root;

        for(Node child : root.getChildren()) {
            //System.out.println(child);
            if(child.getScore() > maxScore) {
                maxScore = child.getScore();
                maxNode = child;
            }
        }

        return maxNode.getMove();

    }


    private void generatePossibleMoves(Node currentNode, boolean max) {
        Board currentBoard = currentNode.getBoard();
        char[][] nextBoardArray;

        char piece;

        if(max) {
            piece = playerPiece;
        } else {
            piece = opponentPiece;
        }

        for(int move : currentBoard.getAvailableMoves()) {
            nextBoardArray = currentNode.getBoard().copyBoardArray();
            Board nextBoard = new Board(nextBoardArray);

            if(nextBoard.checkWinner()) {
                break;
            }

            if(nextBoard.move(move, piece)) {
                currentNode.appendChild(new Node(nextBoard, move));
            }
        }
    }

    private int score(Board board, boolean max, int level) {
        if(board.checkWinner()) {
            if (max) {
                return level - 10;
            } else {
                return 10 - level;
            }
        } else {
            return 0;
        }
    }

    @Override
    public int getMove() {
        Board boardCopy = gameBoard;
        root = new Node(boardCopy, 0);

        minimax(root, true, 0);

        int move = -1;

        move = getMoveFromMinMaxTree(root);
        System.out.println(move);
        return move;
    }


    public int minimax(Node node, boolean max, int level) {
        generatePossibleMoves(node, max);
        level += 1;
        if (node.isLeaf()) {
            node.setScore(score(node.getBoard(), max, level));
            return score(node.getBoard(), max, level);
        }

        if (max) {
            int bestValue = Integer.MIN_VALUE;
            for (Node child : node.getChildren()) {
                int value = minimax(child, false, level);
                bestValue = Math.max(value, bestValue);
            }
            node.setScore(bestValue);
            return bestValue;

        } else {
            int bestValue = Integer.MAX_VALUE;
            for (Node child : node.getChildren()) {
                int value = minimax(child, true, level);
                bestValue = Math.min(value, bestValue);
            }
            node.setScore(bestValue);
            return bestValue;
        }

    }
}
