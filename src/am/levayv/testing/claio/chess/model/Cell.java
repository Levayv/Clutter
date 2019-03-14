package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Piece;

public class Cell {
    //STOPSHIP unique identifier of piece , for testing purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0; // "=0" is redundant AFAIK
    public int getUId() {
        return uId;
    }

    public int asd;
    Cell(){
        uId = uId + count;
        count++;
    }
    private Piece piece;
    public void initialAdd(Piece piece){
        this.piece = piece;
        //update mask ? how ?
        Model.getInstance().mask.setIsOccupied(piece.getPos(),true);
    }
}
