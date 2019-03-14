package am.levayv.testing.claio.chess.model.piece;

public class Pawn extends Piece {


    public Pawn(Owner owner, Pos pos) {
        super(owner, pos);

    }

    @Override
    protected ChessMan init() {
        return ChessMan.PAWN;
    }

}
