package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.piece.data.Owner;

public class Queen extends Piece {
    public Queen(Owner owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.QUEEN;
    }
}
