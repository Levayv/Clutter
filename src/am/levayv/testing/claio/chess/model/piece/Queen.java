package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.QUEEN;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {

    }

}
