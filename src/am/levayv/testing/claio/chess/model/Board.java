package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.data.Owner;
import am.levayv.testing.claio.chess.model.piece.*;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
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
    private Cell[][] cell = new Cell[size][size];
    public Cell getCell(int x, int y){
        return cell[x][y];
    }
    public ArrayList<Piece> pieces = new ArrayList<Piece>();
    public Board(){ // todo is it wise to change size ?
        log.info("Init ...");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = new Cell();
            }
        }
        setUpPieces();
        log.info("Init OK");
    }
    public void traverseCells(){
        //todo implement ! or move to interface
    }
    public void move(Pos from , Pos to){
        // get valid cells
        // move piece from cell 1 to cell 2
    }
    private void setUpPieces(){ // temp
        // pieces are instantiated >>> new Pawn(White), new King(Black)
        // Piece instance references are stored in both
        //      corresponding cell >>> cell[i][j].initialAdd(piece)
        //          initialAdd method returns argument reference for processing
        //      pieces list >>> pieces.add(piece)
        //          easy traversal for each piece on board
        // todo pieces not in play must be removed from arrays
        //
        pieces.add(cell[0][4].initialAdd(new King(Owner.WHITE)));
        pieces.add(cell[7][4].initialAdd(new King(Owner.BLACK)));
        pieces.add(cell[0][3].initialAdd(new Queen(Owner.WHITE)));
        pieces.add(cell[7][3].initialAdd(new Queen(Owner.BLACK)));
        pieces.add(cell[0][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[0][7].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[7][0].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[7][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[0][2].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[0][5].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[7][2].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[7][5].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[0][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[0][6].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[7][1].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[7][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[1][0].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][1].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][2].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][3].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][4].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][5].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][6].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[1][7].initialAdd(new Pawn(Owner.WHITE)));
        pieces.add(cell[6][0].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][1].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][2].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][3].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][6].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][7].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][5].initialAdd(new Pawn(Owner.BLACK)));
        pieces.add(cell[6][4].initialAdd(new Pawn(Owner.BLACK)));
    }
//    private void createPieces(){
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,4)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,4)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,3)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,3)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,0)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,7)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,0)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,7)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,2)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,5)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,2)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,5)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,1)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(0,6)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,1)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(7,6)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,0)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,1)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,2)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,3)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,4)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,5)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,6)));
//        pieces.add(new Pawn(Owner.WHITE , new Pos(1,7)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,0)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,1)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,2)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,3)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,4)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,5)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,6)));
//        pieces.add(new Pawn(Owner.BLACK , new Pos(6,7)));


//        pieces[ 0] = new Pawn(Owner.WHITE);
//        pieces[ 1] = new Pawn(Owner.WHITE);
//        pieces[ 2] = new Pawn(Owner.WHITE);
//        pieces[ 3] = new Pawn(Owner.WHITE);
//        pieces[ 4] = new Pawn(Owner.WHITE);
//        pieces[ 5] = new Pawn(Owner.WHITE);
//        pieces[ 6] = new Pawn(Owner.WHITE);
//        pieces[ 7] = new Pawn(Owner.WHITE);
//        pieces[ 8] = new Pawn(Owner.BLACK);
//        pieces[ 9] = new Pawn(Owner.BLACK);
//        pieces[10] = new Pawn(Owner.BLACK);
//        pieces[11] = new Pawn(Owner.BLACK);
//        pieces[12] = new Pawn(Owner.BLACK);
//        pieces[13] = new Pawn(Owner.BLACK);
//        pieces[14] = new Pawn(Owner.BLACK);
//        pieces[15] = new Pawn(Owner.BLACK);
//
//        pieces[16] = new Pawn(Owner.WHITE);
//        pieces[18] = new Pawn(Owner.WHITE);
//        pieces[17] = new Pawn(Owner.WHITE);
//        pieces[19] = new Pawn(Owner.WHITE);
//        pieces[20] = new Pawn(Owner.WHITE);
//        pieces[21] = new Pawn(Owner.WHITE);
//        pieces[22] = new Pawn(Owner.WHITE);
//        pieces[23] = new Pawn(Owner.WHITE);
//        pieces[24] = new Pawn(Owner.BLACK);
//        pieces[25] = new Pawn(Owner.BLACK);
//        pieces[26] = new Pawn(Owner.BLACK);
//        pieces[27] = new Pawn(Owner.BLACK);
//        pieces[28] = new Pawn(Owner.BLACK);
//        pieces[29] = new Pawn(Owner.BLACK);
//        pieces[30] = new Pawn(Owner.BLACK);
//        pieces[31] = new Pawn(Owner.BLACK);
//    }
}
