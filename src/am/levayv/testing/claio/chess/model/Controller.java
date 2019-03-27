package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

// todo Strip/migrate/refactor all controller functionality from others (Model cell board piece)
// https://github.com/Levayv/Clutter/issues/4

public class Controller {
    // temp logic description
    // initial STATE is WAITING
    // onEvent change STATE from WAITING to MOVING if clicked on piece
    // onEvent change STATE from MOVING to WAITING if move is legit

    private static final Logger log = LogManager.getLogger(Controller.class);
    /** Player's turn BLACK or WHITE*/
    private Color currentPlayer = Color.WHITE;
    /** Previously clicked Cell reference during MOVING state , null during WAITING */
    private Cell activeCell; // which cell's piece to move on click
    /** Minimal State Machine for handling MOVING WAITING logic*/
    StateMachine<Controller, ControllerState> stateMachine;

    Controller() {
        log.info("Init ...");
        stateMachine = new StateMachine<Controller, ControllerState>
                (this, ControllerState.WAITING);
        log.info("Init OK");
    }

    /** ... for FSM */
    Color getCurrentPlayer() {
        return currentPlayer;
    }
    /** ... for FSM */
    void switchPlayer() {
        if (currentPlayer.equals(Color.WHITE))
            currentPlayer = Color.BLACK;
        else
            currentPlayer = Color.WHITE;
    }

    /** ... for FSM */
    Cell getActiveCell() {
        return activeCell;
    }

    /** ... for FSM
     * Handling assignment and divestment of Cell Status NONE or ACTIVE
     * NOTE: WTF is divestment , use unassigned instead , it is not Dictionary of fancy words)
     * */
    void setActiveCell(Cell argCell) {
        if (argCell == null) {
            if (this.activeCell != null) {
                this.activeCell.setStatus(CellStatus.None);
                this.activeCell = null;
            } else {
                // todo delete else block , LITERALLY USELESS
                assert activeCell == null;
                assert argCell == null;
            }
        } else {
            if (this.activeCell != null) {
                this.activeCell.setStatus(CellStatus.None);
                this.activeCell = argCell;
                this.activeCell.setStatus(CellStatus.Active);
            } else {
                this.activeCell = argCell;
                this.activeCell.setStatus(CellStatus.Active);
            }
        }
    }
    //todo get all available moves and updata CELLStatuses
    /** ... for FSM */
    void setCandidateCells(HashSet<Cell> set , boolean isCandidate){
        for (Cell cell:
             set) {
            cell.setStatus(isCandidate ? CellStatus.Candidate : CellStatus.None);
            System.out.println("!!!"+cell.getView().letter);
        }
    }

    public void handleEventAt(Pos pos) { //todo add logger or NOT ?
//        log.info("Handling Internal Event at Field: "+Pos.toCellName(pos));
        stateMachine.getState().onEvent(this, pos);
    }


}
