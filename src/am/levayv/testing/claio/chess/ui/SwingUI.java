package am.levayv.testing.claio.chess.ui;

//todo BUG coloring order of board is wrong , left bottom corner must be dark instead of light color.

import am.levayv.testing.claio.chess.core.swing.SwingApp;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SwingUI extends AbstractUI { //todo logical bug refactor AbstractApp && AbstractUI && Model
    private static final Logger log = LogManager.getLogger(SwingUI.class);

    private JPanel mainPanel;

    private final Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    private final Border moveActiveBorder = BorderFactory.createLineBorder(Color.CYAN, 1);
    private final Border moveCandidateBorder = BorderFactory.createLineBorder(Color.YELLOW, 1);
    private final Font font = new Font("Dialog", Font.BOLD, 44);
    private final Color BLACK_BOARD = new Color(204, 204, 204);
    private final Color WHITE_BOARD = new Color(153, 153, 153);
    private final short buttonWidth = 50;
    private final short buttonHeight = 50;

    private SwingCell[][] buttons = new SwingCell[size][size];
    private final ArrayList<SwingCell> buttonList = new ArrayList<SwingCell>();

    public SwingUI(SwingApp app, JPanel mainPanel, Model model) {
        super(model);
        this.mainPanel = mainPanel;
        mainPanel.setLayout(new GridLayout(size, size));
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
//            for (int i = size - 1; i >= 0; i--) {
//        for (int j = 0; j < size; j++) {
//            for (int j = size - 1; j >= 0; j--) {
                buttons[i][j] = new SwingCell();
                buttons[i][j].setText(" ");
                buttons[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                buttons[i][j].setVerticalAlignment(SwingConstants.CENTER);
                buttons[i][j].setBorder(border);
                buttons[i][j].setFont(font);
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(BLACK_BOARD);
                } else {
                    buttons[i][j].setBackground(WHITE_BOARD);
                }
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(app);
                // buttons[i][j].addMouseListener(this); todo research ActionPerformed vs MouseClick event
                buttons[i][j].setActionCommand(i + "" + j);
//                buttons[i][j].setToolTipText(i + " " + j); // todo change to Pos.toString()
                buttons[i][j].setToolTipText(i + "" + j + "/" + Pos.toCellName(i, j));
                buttons[i][j].setMinimumSize(new Dimension(buttonWidth, buttonHeight));
                buttons[i][j].setPreferredSize(new Dimension(buttonWidth, buttonHeight));
                buttons[i][j].setMaximumSize(new Dimension(buttonWidth, buttonHeight));
                // we got reference of corresponding cell
                buttons[i][j].cellView = model.board.getCell(i, j).getView();
                buttonList.add(buttons[i][j]);
            }
        }
//        for (int i = size - 1; i >= 0; i--) {
        for (int j = size - 1; j >= 0; j--) {
            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {

                mainPanel.add(buttons[i][j]);

//                buttons[i][j].setText(i+""+j);
//                System.out.println("!!! 2d " + buttons[i][j].getText());
            }
        }
//        System.out.println("!!! Al " + buttonList.get(0).getText());
//        System.out.println("!!! Al " + buttonList.get(1).getText());
//        System.out.println("!!! Al " + buttonList.get(2).getText());
//        System.out.println("!!! Al " + buttonList.get(3).getText());
//        System.out.println("!!! Al " + buttonList.get(4).getText());
//        System.out.println("!!! BUG1 ");
//        System.out.println("!!! BUG2 "+model.board.getCell(0,0).getView().letter);
//        System.out.println("!!! BUG3 "+model.board.getCell(0,0).getView().letter);

        // todo refactoring
        // model.board.setUpPieces();
        model.controller.setUp(null);
        this.update();
    }

    @Override
    public void processInput(Pos pos) { //todo try catch ?
        //todo beatify console output
        log.info("Selected Field: "
                + pos.x + " " + pos.y + " " + Pos.toCellName(pos.x, pos.y) + " "
                + ((Model.getInstance().board.getCell(pos.x,pos.y).getView().isOccupied())
                ? Model.getInstance().board.getCell(pos.x,pos.y).getView().letter
                : "NO PIECE")
        );
        model.controller.handleEventAt(pos);
        // update all buttons
        this.update();
    }

    @Override
    public void update() {
        log.info("Updated");
        for (SwingCell button :
                buttonList) {
            String stringBuffer = String.valueOf(button.cellView.icon);
            button.setText(stringBuffer);

            switch (button.cellView.getStatus()) { //todo its ugly i know
                case None:      button.setBorder(border); break;
                case Active:    button.setBorder(moveActiveBorder); break;
                case Candidate: button.setBorder(moveCandidateBorder); break;
            }
        }
    }
}
