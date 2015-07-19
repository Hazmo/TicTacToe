package graphics;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by harry on 18/07/2015.
 */
public class GameGUI extends JFrame {


    GamePanel panel = new GamePanel();

    public GameGUI () {
        add(panel);
        setResizable(false);
        setVisible(true);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addPiece(int move, char piece) {
        if (piece == 'x') {
            panel.crossList.add(new Cross(move));
        } else {
            panel.noughtList.add(new Nought(move));
        }

        panel.repaint();
    }

    public void reset() {
        panel.crossList.clear();
        panel.noughtList.clear();

        panel.repaint();
    }


    public static void main(String args[]) {
        GameGUI gameGUI = new GameGUI();
    }


    private class GamePanel extends JPanel {
        ArrayList<Cross> crossList;
        ArrayList<Nought> noughtList;

        public GamePanel() {
            crossList = new ArrayList<>();
            noughtList = new ArrayList<>();

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(Color.BLACK);
            g2d.fillRect(150, 0, 10, 470);
            g2d.fillRect(310, 0, 10, 470);

            g2d.fillRect(0, 150, 470, 10);
            g2d.fillRect(0, 310, 470, 10);

            g2d.setStroke(new BasicStroke(5));

            for (Cross cross : crossList) {
                cross.paintComponent(g2d);
            }
            for (Nought nought : noughtList) {
                nought.paintComponent(g2d);
            }


        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(470, 470);
        }
    }
}
