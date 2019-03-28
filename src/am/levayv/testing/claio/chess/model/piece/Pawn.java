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
        // step 1. Clear previously present cells from set and the buffer [Done in Piece]
        // step 2. Check Piece color (AKA PlayerColor) is black or white
        if (this.getColor().equals(Color.WHITE)) {
            // move logic to North
            // step 2.1 add pawn's "move forward" logic (WHITE)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH);
            if (cellBuffer!=null)
                if (!cellBuffer.isOccupied())
                    set.add(cellBuffer);
            // step 2.3 add left right diagonal "attack move" logic (WHITE)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH_EAST);
            if (cellBuffer!=null)
                if (cellBuffer.isOccupied())
                    if (cellBuffer.isMine(Color.BLACK))
                        set.add(cellBuffer);
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH_WEST);
            if (cellBuffer!=null)
                if (cellBuffer.isOccupied())
                    if (cellBuffer.isMine(Color.BLACK))
                        set.add(cellBuffer);
            // step 2.2 add "first double move" logic (WHITE)
            if (current.getPiece().isOriginalPos()) { //todo optimise , research needed
                cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.NORTH);
                cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
                if (!cellBuffer.isOccupied())
                    set.add(cellBuffer);
            }
            // step 2.4 add "in passing" logic (WHITE)
                //todo research needed , IMF ghost of Piece in step 2.2
            // step 2.5 add "promotion" logic (WHITE)

        } else {
            //move logic to South
            // step 2.1 add pawn's "move forward" logic (BLACK)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.SOUTH);
            if (cellBuffer!=null){
//                cellBuffer.setStatus(CellStatus.Candidate); //todo migrating to controller
                set.add(cellBuffer);
            }
            // step 2.3 add left right diagonal "attack move" logic (BLACK)
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.SOUTH_EAST);
            if (cellBuffer!=null)
                if (cellBuffer.isOccupied())
                    if (cellBuffer.isMine(Color.WHITE))
                        set.add(cellBuffer);
            cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.SOUTH_WEST);
            if (cellBuffer!=null)
                if (cellBuffer.isOccupied())
                    if (cellBuffer.isMine(Color.WHITE))
                        set.add(cellBuffer);
            // step 2.2 add pawn's "first double move" logic (BLACK)
            if (current.getPiece().isOriginalPos()) { //todo optimise , research needed
                cellBuffer = Navigator.getNearbyCellTo(current, Navigator.Dir.SOUTH);
                cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
                if (!cellBuffer.isOccupied())
                    set.add(cellBuffer);
            }// step 2.4 add "in passing" logic (BLACK)
            // step 2.5 add "promotion" logic (BLACK)

        }
    }
}
