package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cell {
    private static final Logger log = LogManager.getLogger(Cell.class);

    //STOPSHIP unique identifier of piece , for testing purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0;

    public int getUId() {
        return uId;
    }

    public Pos pos;

    Cell() {
        uId = uId + count;
        count++;
    }

    private Piece piece;

    public Piece initialAdd(Piece piece) {
        addPiece(piece);
        return piece;
    }

    public boolean occupied;

    public View getView() {
        if (!occupied)
            return new View();
        else
            return piece.getView();
    }

    public void move() {
    }

    /**
     * Adds Piece to current cell
     *
     * @param piece Object to add
     * @return {@code true} if successful
     * {@code false} otherwise
     * @see #move()
     */
    private boolean addPiece(Piece piece) {
        if (!occupied) {
            this.piece = piece;
            occupied = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes Piece from current Cell
     *
     * @return {@code true} if successful
     * {@code false} otherwise
     * @see #move()
     */
    private boolean removePiece() { //todo refactor ? RetType must be Piece object ?
        if (occupied) {
            this.piece = null;
            occupied = false;
            return true;
        } else {
            return false;
        }
    }
}
