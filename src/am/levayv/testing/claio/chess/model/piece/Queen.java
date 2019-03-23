package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.data.Color;

import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Color owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.QUEEN;
    }

    @Override
    protected HashSet<Cell> updateAvailableMoves(Cell current , HashSet<Cell> set) {
        return null;
    }

}
