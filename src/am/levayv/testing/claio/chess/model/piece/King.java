package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.piece.data.Owner;

public class King extends Piece {
    public King(Owner owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.KING;
    }
}
