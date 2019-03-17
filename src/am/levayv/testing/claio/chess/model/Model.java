package am.levayv.testing.claio.chess.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Model { //aka root , AFAIK domain model
    private static final Logger log = LogManager.getLogger(Model.class);
    private static final Model instance = new Model();
    private Model(){
        log.info("Init ...");
//        mask = new Mask();
        board = new Board();
//        calcMasks();
        log.info("Init OK");
    }
    public static Model getInstance(){
        return instance;
    }
    // i hope singleton works
    // ...

//    @Deprecated
//    public Mask mask;

    public Board board;
    // movement prototype //todo IMF
    private Round round = new Round();


//    @Deprecated
//    public void calcMasks(){
//        for (Piece next :
//                board.pieces) {
//            Pos pos = next.getPos();
////            mask.isOccupied[pos.x][pos.y] = true; //todo delete me
//            mask.setIsOccupied(pos,true);
////            mask.isWhite[pos.x][pos.y] = next.isWhite(); //todo delete me too !
//            mask.setIsWhite(pos,next.isWhite());
////            mask.id[pos.x][pos.y] = next.getName(); //todo ME TOO ME TOO !!!
//            mask.setType(pos,next.getType());
//        }
//    }
    public static int getBoardSize(){
        return Board.getSize();
    }
}
