package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.data.Owner;
import am.levayv.testing.claio.chess.model.piece.*;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Board {

    //Board MUST be square , rectangular shapes NOT supported
    private static final Logger log = LogManager.getLogger(Board.class);
    private final static int size = 8;
    public static int getSize(){return size;}
//    private final static int pieceCount = 32;
//    private final static int cellCount = size*size;
    private Cell[][] cell;
    public Cell getCell(int x, int y){
        inBoundsAssertion(x,y);
        return cell[x][y];
    }

    public Cell getCell(Pos pos){
        inBoundsAssertion(pos);
        return cell[pos.x][pos.y];
    }
    public ArrayList<Piece> pieces = new ArrayList<Piece>();
    public Board(){ // todo is it wise to change size ?
        log.info("Init ...");
        cell = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = new Cell(i,j);
            }
        }
        log.info("Init OK");
    }
    public void traverseCells(){
        //todo implement ! or move to interface
    }
    private void move(){

    }
    public void moveFromTo(Pos from , Pos to){
        // get valid cells
        // move piece from cell 1 to cell 2

    }
    //todo move to Controller
//    @Deprecated
//    public boolean moveFrom(Pos from){
//        Cell cell = getCellByPos(from);
//        // if else if else with return , i smell bad practice
//        if (cell.isOccupied()){
//            if (cell.canMoveThePiece()){ //todo simplify
//                return true;
//            } else {
//                //do nothing
//                return false;
//            }
//        }else {
//            //do nothing
//            return false;
//        }
//// todo delete me
////        if (cell.isOccupied() && cell.canMoveThePiece()){
////            return true;
////        }else {
////            return false;
////        }
//    }
    //todo move to Controller
    @Deprecated
    public void moveTo(Pos to){

    }
    // delete helper , used Navigator class
    private Helper helper = new Helper();
    //todo find duplicate methods after "move to/from" methods migrate to controller
    private Cell getCellByPos(Pos pos){
        return cell[pos.x][pos.y];
    }
    public void setUpPieces(){ // temp
        // pieces are instantiated >>> new Pawn(White), new King(Black)
        // Piece instance references are stored in both
        //      corresponding cell >>> cell[i][j].initialAdd(piece)
        //          initialAdd method returns argument reference for processing
        //      pieces list >>> pieces.add(piece)
        //          easy traversal for each piece on board
        // todo pieces not in play must be removed from arrays ?
        //
        pieces.add(cell[4][0].initialAdd(new King(Owner.WHITE)));
        pieces.add(cell[4][7].initialAdd(new King(Owner.BLACK)));
        pieces.add(cell[3][0].initialAdd(new Queen(Owner.WHITE)));
        pieces.add(cell[3][7].initialAdd(new Queen(Owner.BLACK)));
        pieces.add(cell[0][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[7][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[0][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[7][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[2][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[5][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[2][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[5][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[1][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[6][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[0][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[2][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[3][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[4][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[5][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[6][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[7][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[0][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[1][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[2][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[3][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[7][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[5][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[4][6].initialAdd(new Pawn(Owner.BLACK)));
    }

    @Deprecated // //STOPSHIP research assert
    public static void inBoundsAssertion(byte x , byte y){
        assert x >= 0;
        assert y >= 0;
        assert x < size;
        assert y < size;
    }
    @Deprecated // //STOPSHIP research assert
    public static void inBoundsAssertion(int x , int y){
        assert x >= 0;
        assert y >= 0;
        assert x < size;
        assert y < size;
    }
    @Deprecated // //STOPSHIP research assert
    public static void inBoundsAssertion(Pos pos){
        assert pos.x >= 0;
        assert pos.y >= 0;
        assert pos.x < size;
        assert pos.y < size;
    }
}