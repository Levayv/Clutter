package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.BISHOP;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - Queen move unlmited cells in any direction , total of 8 directions max 27 !
        for (Navigator.Dir dir:
                Navigator.Dir.values()) {

            // ignore diagonal moves 0123 ~ 4567
            if (dir.ordinal()>=4) //todo refactor Dir enum
                this.baseTraversal(current,dir);
        }
    }


}
