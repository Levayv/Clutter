package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.CellStatus;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.PAWN;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - pawns move only 1 cell forward (see steps 2.2 >>> 2.5)

        // step 1. Clear previously present cells from set and the buffer
        if (!set.isEmpty()){
//            for (Cell eachCell : set) { //refactor foreach
//                eachCell.setStatus(CellStatus.None);
//            } //todo migrating to controller
            set.clear();
        }
        cellBuffer = null;
        // step 2. Check Piece color (AKA PlayerColor) is black or white
        if (this.getColor().equals(Color.WHITE)) {
            // move logic to North
            // step 2.1 add pawn's "move forward" logic (WHITE)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH);
            // Navigator returns null if out of Board's bounds
            if (cellBuffer!=null){
//                cellBuffer.setStatus(CellStatus.Candidate); //todo migrating to controller
                set.add(cellBuffer);
            }
            // step 2.2 add pawn's "first double move" logic (WHITE)
            // step 2.3 add left right diagonal "attack move" logic (WHITE)
            // step 2.4 add "in passing" logic (WHITE)
            // step 2.5 add "promotion" logic (WHITE)

        } else {
            //move logic to South
            // step 2.1 add pawn's "move forward" logic (BLACK)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.SOUTH);
            if (cellBuffer!=null){
//                cellBuffer.setStatus(CellStatus.Candidate); //todo migrating to controller
                set.add(cellBuffer);
            }
            // step 2.2 add pawn's "first double move" logic (BLACK)
            // step 2.3 add left right diagonal "attack move" logic (BLACK)
            // step 2.4 add "in passing" logic (BLACK)
            // step 2.5 add "promotion" logic (BLACK)

        }
    }
}
