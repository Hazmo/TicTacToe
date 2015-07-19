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

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.fillRect(150, 0, 10, 470);
        g2d.fillRect(310, 0, 10, 470);

        g2d.fillRect(0, 150, 470, 10);
        g2d.fillRect(0, 310, 470, 10);

        g2d.setStroke(new BasicStroke(5));

        g2d.drawOval(160 + 10, 2 * 160 + 10, 130, 130);


        new Cross(5).paintComponent(g2d);


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
