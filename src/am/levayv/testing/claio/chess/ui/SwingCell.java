package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.CellView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class SwingCell extends JButton{
    final CellView cellView;

    JLabel topLeft;
    JLabel topRight;
    JLabel botLeft;
    JLabel botRight;
    private final Font fontSmall = new Font("Dialog", Font.BOLD, 20);
//    private final Border border = BorderFactory.createLineBorder(Color.RED, 1);

    /** SwingCell is storing ONLY views of corresponding Cells*/
    SwingCell(CellView cellView) {
        this.cellView = cellView;

        //todo temp
//        topLeft = new JLabel("1 TL");
//        topRight = new JLabel("1 TR");
//        botLeft = new JLabel("1 BL");
//        botRight = new JLabel("1 BR");
        topLeft  = new JLabel(   "0");
        topRight = new JLabel(  "0");
        botLeft  = new JLabel(   "0");
        botRight = new JLabel(  "0");
//        topLeft .setBorder(border);
//        topRight.setBorder(border);
//        botLeft .setBorder(border);
//        botRight.setBorder(border);

        topLeft.setVerticalAlignment(JLabel.TOP);
        topLeft.setHorizontalAlignment(JLabel.LEFT);

        topRight.setVerticalAlignment(JLabel.TOP);
        topRight.setHorizontalAlignment(JLabel.RIGHT);

        botLeft.setVerticalAlignment(JLabel.BOTTOM);
        botLeft.setHorizontalAlignment(JLabel.LEFT);

        botRight.setVerticalAlignment(JLabel.BOTTOM);
        botRight.setHorizontalAlignment(JLabel.RIGHT);

        this.setLayout(new GridLayout(3,3));
        this.add(topLeft);
        this.add(new JLabel());
        this.add(topRight);
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(botLeft);
        this.add(new JLabel());
        this.add(botRight);
    }
}
