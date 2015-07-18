package graphics;
import javax.swing.*;
import java.awt.*;

/**
 * Created by harry on 18/07/2015.
 */
public class BoardGUI extends JPanel {

    public BoardGUI() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.BLACK);
        g.fillRect(150, 0, 10, 470);
        g.fillRect(310, 0, 10, 470);

        g.fillRect(0, 150, 470, 10);
        g.fillRect(0, 310, 470, 10);


    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(470, 470);
    }

    public static void main(String args[]) {
        BoardGUI boardGUI = new BoardGUI();
        JFrame test = new JFrame();
        test.add(boardGUI);;
        test.setResizable(true);
        test.pack();
        test.setVisible(true);
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
