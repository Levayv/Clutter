package am.levayv.testing.claio.chess.model.piece;

public abstract class Piece {
    private ChessMan name;
    private Owner owner;
    private Pos pos;
    //STOPSHIP unique identifier of piece , for testing purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0; // "=0" is redundant AFAIK

//    public abstract void move();

    public Piece(Owner owner, Pos pos) {
        name = init();
        this.owner = owner;
        this.pos = pos;
        uId = uId + count;
        count++;
    }
    protected abstract ChessMan init();

    public Pos getPos() {
        return pos;
    }

    public boolean isWhite() {
        return owner.equals(Owner.WHITE);
    }

    public ChessMan getName() {
        return name;
    }

    public int getUId() {
        return uId;
    }



}
