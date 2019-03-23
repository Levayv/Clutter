package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Board;
import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.data.Owner;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

import java.util.HashSet;

public abstract class Piece {
    private ChessMan type;
    private Owner owner;
//    private View view; //todo delete
    private HashSet<Cell> availableMoves;
    // todo cellBuffer write info comment
    protected Cell cellBuffer;
    /** Piece must NOT have a position , Piece assigned to cell, which had a position (refactor in progress)*/
    @Deprecated
    private Pos pos;
    //STOPSHIP unique identifier of piece , for pre alpha purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0; // "=0" is redundant AFAIK

    public Piece(Owner owner) {
        this.owner = owner;
        this.type = initType();
        this.availableMoves = new HashSet<Cell>();

//        this.view = new View();
//        this.pos = pos;

        uId = uId + count;
        count++;
    }

    protected abstract ChessMan initType();
    //refactor view to cell


    public boolean canMove(Cell currentCell){
        updateAvailableMoves(currentCell, availableMoves);
        return !availableMoves.isEmpty();
    }
    public boolean canArrive(Cell destination){
        //todo delete me
//        System.out.println("!!! 1");
//        assert destination != null;
//        assert availableMoves != null;
//        assert availableMoves.size() == 1;
//        assert availableMoves.contains(destination);
//        System.out.println("!!! 2");
        return availableMoves.contains(destination);
    }

    protected abstract HashSet<Cell> updateAvailableMoves(Cell current , HashSet<Cell> set);

    @Deprecated
    public Pos getPos() {
        return pos;
    }

    public boolean isWhite() { //todo reconsider refactoring
        return owner.equals(Owner.WHITE);
    }
    public Owner getOwner() { //todo reconsider refactoring
        return owner;
    }

    public ChessMan getType() {
        return type;
    }

    public int getUId() {
        return uId;
    }


//    public View getView(){
//        return view;
//    }
}
