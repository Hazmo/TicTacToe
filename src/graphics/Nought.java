package graphics;

import java.awt.*;

/**
 * Created by harry on 19/07/2015.
 */
public class Nought {
    int row;
    int col;

    public Nought(int pos) {
        row = (pos - 1) / 3;
        col = (pos - 1) % 3;
    }

    public void paintComponent(Graphics2D g2d) {
        int rowSquare = row * 160;
        int colSquare = col * 160;
        g2d.drawOval(colSquare + 10, rowSquare + 10, 130, 130);
    }


}
