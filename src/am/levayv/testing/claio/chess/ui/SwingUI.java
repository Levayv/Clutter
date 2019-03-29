package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.core.swing.SwingApp;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class SwingUI extends AbstractUI { //todo logical bug refactor AbstractApp && AbstractUI && Model
    private static final Logger log = LogManager.getLogger(SwingUI.class);

    private final Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    private final Border moveActiveBorder = BorderFactory.createLineBorder(Color.CYAN, 1);
    private final Border moveCandidateBorder = BorderFactory.createLineBorder(Color.YELLOW, 1);

    private SwingCell[][] buttons = new SwingCell[size][size];
    private final ArrayList<SwingCell> buttonList = new ArrayList<SwingCell>();

    /**
     *  ...
     * @param app Required for Listeners
     * @param mainPanel Will be populated with 64 squares
     * */
    public SwingUI(SwingApp app, JPanel mainPanel) {
        final Font font = new Font("Dialog", Font.BOLD, 44);
        final Color BLACK_BOARD = new Color(204, 204, 204);
        final Color WHITE_BOARD = new Color(153, 153, 153);
        final short buttonWidth = 50;
        final short buttonHeight = 50;
        final Dimension minDim = new Dimension(buttonWidth, buttonHeight);
        final Dimension prfDim = new Dimension(buttonWidth, buttonHeight);
        final Dimension maxDim = new Dimension(buttonWidth, buttonHeight);

        mainPanel.setLayout(new GridLayout(size, size));
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                // Getting reference of corresponding cell's views from Model
                buttons[i][j] = new SwingCell(model.board.getCell(i, j).getView());
                if ((i + j) % 2 == 0) {
                    buttons[i][j].setBackground(WHITE_BOARD);
                } else {
                    buttons[i][j].setBackground(BLACK_BOARD);
                }
                buttons[i][j].setActionCommand(i + "" + j);
                buttons[i][j].setToolTipText(i + "" + j + "/" + Pos.toCellName(i, j));
                buttonList.add(buttons[i][j]);
            }
        }
        for (JButton button :
                buttonList) {
//            button.setText(" "); //todo redundant ?
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.setBorder(border);
            button.setFont(font);
            button.setFocusPainted(false);
            button.addActionListener(app);
            button.setMinimumSize(minDim);
            button.setPreferredSize(prfDim);
            button.setMaximumSize(maxDim);
        }
        // Adding to mainPanel in specific order (Research BorderLayout)
        for (int j = size - 1; j >= 0; j--) {
            for (int i = 0; i < size; i++) {
                mainPanel.add(buttons[i][j]);
            }
        }
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
