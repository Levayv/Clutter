package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.ChessMan;
import am.levayv.testing.claio.chess.model.piece.Pos;

public class Mask {
    private final int size = Model.getBoardSize();
    private ChessMan[][] type; //todo refactor enums
    private boolean[][] isOccupied;
    private boolean[][] isWhite;


    public Mask(){
        // allocate everything
        type      = new ChessMan[size][size];
        isOccupied    = new boolean[size][size];
        isWhite     = new boolean[size][size];


//        considered bad practice ?
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                someID[i][j] = 0;
//            }
//        }

        // init
//        for(ChessMan[] someIDRows: id){
//            for(ChessMan next: someIDRows)
//                next = ChessMan.PAWN;
//        }
    }

    public boolean getIsOccupied(Pos pos) {
        return isOccupied[pos.x][pos.y];
    }

    public void setIsOccupied(Pos pos, boolean arg) {
        this.isOccupied[pos.x][pos.y] = arg;
    }

    public boolean getIsWhite(Pos pos) {
        return isWhite[pos.x][pos.y];
    }

    public void setIsWhite(Pos pos, boolean arg) {
        this.isWhite[pos.x][pos.y] = arg;
    }
    public ChessMan getType(Pos pos) {
        return type[pos.x][pos.y];
    }

    public void setType(Pos pos, ChessMan arg) {
        this.type[pos.x][pos.y] = arg;
    }
}
