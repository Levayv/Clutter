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
                buttons[i][j].cell = model.board.getCell(i, j);
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
        model.board.setUpPieces();
//        System.out.println("!!! BUG3 "+model.board.getCell(0,0).getView().letter);

        this.update();
    }

    @Override
    public void processInput(Object event) { //todo try catch ?
        if (event != null) { //todo optimise
            if (event instanceof ActionEvent) {
                ActionEvent actionEvent = (ActionEvent) event;
                if (actionEvent.getActionCommand() != null) {
                    if (!actionEvent.getActionCommand().isEmpty()) {
                        //get coordinates from input
                        int t = Integer.valueOf(actionEvent.getActionCommand());
                        int x = t / 10, y = t % 10;
                        //todo beatify console output
                        log.info("Selected Field: "
                                + x + " " + y + " " + Pos.toCellName(x, y) + " "
                                + ((Model.getInstance().board.getCell(x,y).getView().isOccupied())
                                ? Model.getInstance().board.getCell(x,y).getView().letter
                                : "NO PIECE")
                        );
                        //todo refactor SMELL creating new object each time !

                        model.controller.handleEventAt(new Pos(x, y));

                        // update all buttons
                        this.update();
                    } else {
                        log.info("processing Input : can't handle input , event is not cell button command ");
                    }
                } else {
                    log.info("processing Input : can't handle input , event's command is null");
                }
            } else {
                log.info("processing Input : can't handle input , event is Unknown");
            }
        } else {
            log.info("processing Input : can't handle input , event is NULL");
        }

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
        log.info("Updated");
//        System.out.println("!!! !!22"); //todo ASAP
//        model.board.getCell(0,0).getView(). // todo refactor
        for (SwingCell button :
                buttonList) {
//            System.out.println("!!! 123 B" + ((button!=null)?"true":"false"));
//            System.out.println("!!! 123 C" + ((button.cell!=null)?"true":"false"));
//            System.out.println("!!! 123 V" + ((button.cell.getView()!=null)?"true":"false"));
//            if (button.cell.getView()==null){
//                System.out.println("!!! Boom Pre - "
//                        + button.cell.pos.x + "/"
//                        + button.cell.pos.y
//                );
//            }
//            System.out.println("!!! 123 I" + ((button.cell.getView().icon!=0)?"true":"false"));
            String stringBuffer = String.valueOf(button.cell.getView().icon);
            button.setText(stringBuffer);

            switch (button.cell.getView().getStatus()) { //todo its ugly i know
                case None:      button.setBorder(border); break;
                case Active:    button.setBorder(moveActiveBorder); break;
                case Candidate: button.setBorder(moveCandidateBorder); break;
            }

//            if (button.cell.getView().isActive()){
//            } else {
//                if (button.cell.getView().isCandidate()){
//                    button.setBorder(moveCandidateBorder);
//                }else {
//                    button.setBorder(border);
//                }
//            }




//            if (button.cell.isActive()){
//                button.setBorder(moveActiveBorder);
//            }else {
//                button.setBorder(border);
//            }

        }




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
