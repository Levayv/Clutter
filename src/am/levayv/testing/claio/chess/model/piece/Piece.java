package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.View;
import am.levayv.testing.claio.chess.model.piece.data.Owner;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

public abstract class Piece {
    private ChessMan type;
    private Owner owner;
    private View view;
    /** Piece must NOT have a position , Piece assigned to cell, which had a position (refactor in progress)*/
    @Deprecated
    private Pos pos;
    //STOPSHIP unique identifier of piece , for testing purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0; // "=0" is redundant AFAIK

    public Piece(Owner owner) {
        this.owner = owner;
        this.type = initType();
        this.view = initView();

//        this.view = new View();
//        this.pos = pos;

        uId = uId + count;
        count++;
    }

    protected abstract ChessMan initType();
    private View initView(){
        char icon = type.getIcon(owner == Owner.WHITE);
        char letter = type.getLetter(owner == Owner.WHITE);
        view = new View(icon, letter);
        System.out.println("!!! init piece test : " + view.icon + " " + view.letter);
        return view;
    }

    public boolean canMove(){
        // todo IMF - check if current piece got available moves
        return true;
    }

    @Deprecated
    public Pos getPos() {
        return pos;
    }

    public boolean isWhite() {
        return owner.equals(Owner.WHITE);
    }

    public ChessMan getType() {
        return type;
    }

    public int getUId() {
        return uId;
    }


    public View getView(){
        return view;
    }
}
