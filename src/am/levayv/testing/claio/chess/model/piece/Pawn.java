package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.Status;
import am.levayv.testing.claio.chess.model.piece.data.Color;

import java.util.HashSet;
import java.util.Iterator;

public class Pawn extends Piece {

//    private Model model = Model.getInstance();
    public Pawn(Color owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.PAWN;
    }

    @Override
    protected HashSet<Cell> updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - pawns move only 1 cell forward (see steps 2.2 >>> 2.5)

        // todo suspicious code , research Collection Framework
        if (!set.isEmpty()){
            for (Cell eachCell : set) { //refactor foreach
                eachCell.setStatus(Status.None);
            }
        }

        // step 1. Clear previously present cells from set and the buffer
        set.clear();
        cellBuffer = null;
        // step 2. Check Piece color (AKA owner) is black or white
        if (this.getOwner().equals(Color.WHITE)) {
            // move logic to North
            // step 2.1 add pawn's "move forward" logic (WHITE)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH);
            if (cellBuffer!=null){
                cellBuffer.setStatus(Status.Candidate);
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
                cellBuffer.setStatus(Status.Candidate);
                set.add(cellBuffer);
            }
            // step 2.2 add pawn's "first double move" logic (BLACK)
            // step 2.3 add left right diagonal "attack move" logic (BLACK)
            // step 2.4 add "in passing" logic (BLACK)
            // step 2.5 add "promotion" logic (BLACK)
        }

//        set.add(Model.getInstance().board.getCell(Navigator.getCells()));
//        set = Navigator.getCells(set);

        return set;
    }

}
