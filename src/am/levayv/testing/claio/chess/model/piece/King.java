package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.data.Owner;

import java.util.HashSet;

public class King extends Piece {
    public King(Owner owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.KING;
    }

    @Override
    protected HashSet<Cell> updateAvailableMoves(Cell current , HashSet<Cell> set) {
        return null;
    }
}
