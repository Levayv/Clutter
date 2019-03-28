package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.KNIGHT;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - Queen move unlmited cells in any direction , total of 8 directions max 27 !
        for (Navigator.Dir dir:
                Navigator.Dir.values()) {

            // todo IMF static 8 fields no traversal

        }
    }


}
