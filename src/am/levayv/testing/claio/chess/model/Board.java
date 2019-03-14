package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Owner;
import am.levayv.testing.claio.chess.model.piece.Pawn;
import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.model.piece.Pos;

import java.util.*;

public class Board {

    //Board MUST be square , rectangular shapes NOT supported
    private final static int size = 8;
    private final static int pieceCount = 32;
//    private final static int cellCOunt = 64;
    /* todo DELETE public Piece[] pieces = new Piece[32]; */
    private Cell[][] cell = new Cell[size][size];
    public ArrayList<Piece> pieces = new ArrayList<Piece>();
    public Board(){ // todo is it wise to change size ?
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = new Cell();
            }
        }
        createPieces();
        setUpPieces();
    }
    public void traverseCells(){
        //todo implement ! or move to interface
    }
    public void move(Pos from , Pos to){
        // get valid cells
        // move piece from cell 1 to cell 2
    }
    public static int getSize(){return size;}
    private void setUpPieces(){

    }
    private void createPieces(){
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,4)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,4)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,3)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,3)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,0)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,7)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,0)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,7)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,2)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,5)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,2)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,5)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,1)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(0,6)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,1)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(7,6)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,0)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,1)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,2)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,3)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,4)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,5)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,6)));
        pieces.add(new Pawn(Owner.WHITE , new Pos(1,7)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,0)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,1)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,2)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,3)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,4)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,5)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,6)));
        pieces.add(new Pawn(Owner.BLACK , new Pos(6,7)));


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
    }
}
