package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.model.piece.Pos;

public class Model {
    private static final Model instance = new Model();
    private Model(){
        mask = new Mask();
        board = new Board();
        calcMasks();
    }
    public static Model getInstance(){
        return instance;
    }
    // i hope singleton works
    // ...
    public Mask mask;
    public Board board;

    public void calcMasks(){
        for (Piece next :
                board.pieces) {
            Pos pos = next.getPos();
//            mask.isOccupied[pos.x][pos.y] = true; //todo delete me
            mask.setIsOccupied(pos,true);
//            mask.isWhite[pos.x][pos.y] = next.isWhite(); //todo delete me too !
            mask.setIsWhite(pos,next.isWhite());
//            mask.id[pos.x][pos.y] = next.getName(); //todo ME TOO ME TOO !!!
            mask.setType(pos,next.getName());
        }
    }
    public static int getBoardSize(){
        return Board.getSize();
    }
}
