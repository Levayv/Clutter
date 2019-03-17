package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.piece.data.Owner;

public class Pawn extends Piece {

    public Pawn(Owner owner) {
        super(owner);
    }

    @Override
    protected ChessMan initType() {
        return ChessMan.PAWN;
    }

}
