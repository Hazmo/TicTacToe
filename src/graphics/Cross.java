package graphics;

import java.awt.*;

/**
 * Created by harry on 19/07/2015.
 */
public class Cross {
    private int row;
    private int col;



    public Cross(int pos) {
        row = (pos - 1) / 3;
        col = (pos - 1) % 3;
    }


    public void paintComponent(Graphics2D g2d) {
        int rowSquare = row * 160;
        int colSquare = col * 160;

        g2d.drawLine(colSquare + 10, rowSquare + 10, colSquare + 140, rowSquare + 140);
        g2d.drawLine(colSquare + 140, rowSquare + 10, colSquare + 10, rowSquare + 140);

    }
}
