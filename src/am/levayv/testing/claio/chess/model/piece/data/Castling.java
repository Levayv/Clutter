package am.levayv.testing.claio.chess.model.piece.data;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.King;
import am.levayv.testing.claio.chess.model.piece.Rook;

public class Castling {
    public boolean left; //todo encapsulate
    public boolean right;
    private boolean availableLeft = false;
    private boolean availableRight = false;
    private boolean active = false;
    private boolean activeLeft = false;
    private boolean activeRight = false;
    private final King king;
    private final Cell cell1_leftEmptySpace;
    private final Cell cell2_leftKingDestination;
    private final Cell cell3_leftRookDestination;
    private final Cell cell4_rightRookDestination;
    private final Cell cell5_rightKingDestination;
    private final Cell rookAtLeftCell;
    private final Cell rookAtRightCell;
//    private final Cell leftKingDestination;
//    private final Cell rightKingDestination;
//    private final Cell leftRookDestination;
//    private final Cell rightRookDestination;

    public Castling(King king,
                    Cell cell1_leftEmptySpace,
                    Cell cell2_leftKingDestination,
                    Cell cell3_leftRookDestination,
                    Cell cell4_rightRookDestination,
                    Cell cell5_rightKingDestination,
                    Cell rookAtLeftCell,
                    Cell rookAtRightCell){
        this.king = king;
        this.cell1_leftEmptySpace = cell1_leftEmptySpace;
        this.cell2_leftKingDestination = cell2_leftKingDestination;
        this.cell3_leftRookDestination = cell3_leftRookDestination;
        this.cell4_rightRookDestination = cell4_rightRookDestination;
        this.cell5_rightKingDestination = cell5_rightKingDestination;
        this.rookAtLeftCell = rookAtLeftCell;
        this.rookAtRightCell = rookAtRightCell;
    }

    public void update() {
        // clear previous values
        availableLeft = false;
        availableRight = false;
        // Rule: King must not been moved at all
        if (king.isOriginalPos()) {
            // Rule: Left Rook must not been moved at all
            if (rookAtLeftCell.getPiece() instanceof Rook) {
                if (rookAtLeftCell.getPiece().isOriginalPos()) {
                    // 3 cells on King right side must be empty
                    if (!cell1_leftEmptySpace.isOccupied()) {
                        if (!cell2_leftKingDestination.isOccupied()) {
                            if (!cell3_leftRookDestination.isOccupied()) {
                                if (true) { //todo IMF isUnderThreat()
                                    availableLeft = true;
                                }
                            }
                        }
                    }
                }
            }
            // Rule: Right Rook must not been moved at all
            if (rookAtRightCell.getPiece() instanceof Rook) {
                if (rookAtRightCell.getPiece().isOriginalPos()) {
                    // 2 cells on King left side must be empty
                    if (!cell4_rightRookDestination.isOccupied()) {
                        if (!cell5_rightKingDestination.isOccupied()) {
                            if (true) { //todo IMF isUnderThreat()
                                availableRight = true;
                            }
                        }
                    }
                }
            }

        }
    }
    public boolean isAvailableLeft(){
        return availableLeft;
    }
    public boolean isAvailableRight(){
        return availableRight;
    }
    public Cell getCellRookLeftFrom(){
        return rookAtLeftCell;
    }
    public Cell getCellRookLeftTo(){
        return cell3_leftRookDestination;
    }
    public Cell getCellRookRightFrom(){
        return rookAtRightCell;
    }
    public Cell getCellRookRightTo(){
        return cell4_rightRookDestination;
    }
    public Cell getCellKingLeft(){
        return cell2_leftKingDestination;
    }
    public Cell getCellKingRight(){
        return cell5_rightKingDestination;
    }
}
