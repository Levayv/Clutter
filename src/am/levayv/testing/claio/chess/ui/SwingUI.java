package am.levayv.testing.claio.chess.ui;

//todo BUG coloring order of board is wrong , left bottom corner must be dark instead of light color.

import am.levayv.testing.claio.chess.core.swing.SwingApp;
import am.levayv.testing.claio.chess.model.Model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SwingUI extends AbstractUI {
    private static final Logger log = LogManager.getLogger(SwingUI.class);

    private JPanel mainPanel;

    private final Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    private final Font font = new Font("Dialog", Font.BOLD, 44);
    private final Color BLACK_BOARD = new Color(204,204,204);
    private final Color WHITE_BOARD = new Color(153, 153, 153);
    private final short buttonWidth   = 50;
    private final short buttonHeight  = 50;

    private SwingCell[][] buttons = new SwingCell[size][size];
    private ArrayList<SwingCell> buttonList = new ArrayList<SwingCell>();
    public SwingUI(SwingApp app, JPanel mainPanel, Model model) {
        super(model);
        this.mainPanel = mainPanel;
        mainPanel.setLayout(new GridLayout(size,size));
        for (int i = size-1 ; i >= 0; i--) {
//            for (int j = 0; j < size; j++) {
            for (int j = size-1; j >= 0; j--) {
                buttons[i][j] = new SwingCell();
                buttons[i][j].setText(" ");
                buttons[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                buttons[i][j].setVerticalAlignment(SwingConstants.CENTER);
                buttons[i][j].setBorder(border);
                buttons[i][j].setFont(font);
                if ((i+j)%2==0) {
                    buttons[i][j].setBackground(BLACK_BOARD);
                }
                else {
                    buttons[i][j].setBackground(WHITE_BOARD);
                }
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(app);
                // buttons[i][j].addMouseListener(this); todo research ActionPerformed vs MouseClick event
                buttons[i][j].setActionCommand(i+""+j);
                buttons[i][j].setToolTipText(i + " " + j); // todo change to Pos.toString()
//                buttons[i][j].setToolTipText(Pos.toCellName(i,j));
                buttons[i][j].setMinimumSize(new Dimension(buttonWidth, buttonHeight));
                buttons[i][j].setPreferredSize(new Dimension(buttonWidth, buttonHeight));
                buttons[i][j].setMaximumSize(new Dimension(buttonWidth, buttonHeight));
                // we got reference of corresponding cell
                buttons[i][j].cell = model.board.getCell(i,j);
            }
        }
        for (int i = size-1 ; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                mainPanel.add(buttons[i][j]);
                buttonList.add(buttons[i][j]);
//                buttons[i][j].setText(i+""+j);
//                System.out.println("!!! 2d " + buttons[i][j].getText());
            }
        }
//        System.out.println("!!! Al " + buttonList.get(0).getText());
//        System.out.println("!!! Al " + buttonList.get(1).getText());
//        System.out.println("!!! Al " + buttonList.get(2).getText());
//        System.out.println("!!! Al " + buttonList.get(3).getText());
//        System.out.println("!!! Al " + buttonList.get(4).getText());
    }

    @Override
    public void processInput(Object e) {
        log.info("processInput arg (hashCode) = " + e.hashCode());
        System.out.println("!");
        this.update();
        ActionEvent e2 = (ActionEvent) e;
        int t = Integer.valueOf(e2.getActionCommand());
        int h = t / 10, w = t % 10;     //get coordinates from input
        System.out.print("Field: " + h + "" + w + " ");

        //todo REMOVE THIS - gist from older version
        //        if (button[h][w].Piece.real) System.out.print(" real ");
//        if (button[h][w].Piece.white) System.out.print("white ");
//        System.out.print(buttons[h][w].Piece.type + " " + buttons[h][w].Piece.icon);
//        System.out.println(" ! (" + moving + ")");
//
//        if (turn){  //if your turn
//            move(h,w);
//
//        }else{  // MUST BE REPLACED WHITH AI
//            //////////////////////////////////////////////////////////////////
//            move(h,w);
//        }
    }

    @Override
    public void update() {
        for (SwingCell button :
                buttonList) {
            String buffer = String.valueOf(button.getView().icon);
            button.setText(buffer);
        }
        System.out.println("!!!");
        System.out.println("!!! " + buttons[5][5].getView().icon);
        buttons[5][5].setText("!");

//        for (int i = size-1 ; i >= 0; i--) {
//            for (int j = 0; j < size; j++) {
//                Pos pos = new Pos(i,j);
//                if (model.mask.getIsOccupied(pos)){
////                    buttons[i][j].setText(String.valueOf(model.mask.id[i][j].ordinal()));
//                    buttons[i][j].setText(
//                            String.valueOf(
//                                    model.mask.getType(pos).getIcon(
//                                            model.mask.getIsWhite(pos)
//                                    )
//                            )
//                    );
//                }
//            }
//        }

    }
}
