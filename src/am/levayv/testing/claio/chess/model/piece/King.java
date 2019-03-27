package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.KING;
    }

    @Override
    protected HashSet<Cell> updateAvailableMoves(Cell current , HashSet<Cell> set) {
        return null;
    }
}
