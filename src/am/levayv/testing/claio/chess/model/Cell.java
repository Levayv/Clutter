package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class Cell{
    private static final Logger log = LogManager.getLogger(Cell.class);

    // Cell status can be PASSIVE ACTIVE CANDIDATE
    private CellStatus status = CellStatus.None;
    @Deprecated //todo research packaging
    public void setStatus(CellStatus status) {
        this.status = status;
        this.view.setStatus(status);
    }

    // View
    private View view;

    // Pos
    Pos pos;

    // Piece
    Piece piece;

    // IDIOT POSITIONS ARE NOT DEFINED WHEN CREATING THE GODDAMN CELL !
    Cell(int x , int y) {
        overflowWatchdog();

        this.pos = new Pos(x,y); // todo refactor position init
        initView(); //todo refactor
    }
    private void initView(){
        view = new View();
    }
    public View getView() {
        return this.view;
    }

    private void updateView() {
        if (isOccupied()) {
            view.icon = piece.getType().getIcon(piece.isWhite());
            view.letter = piece.getType().getLetter(piece.isWhite());
        } else {
            view.setEmpty();
        }
    }

    boolean isMine(Color color){
        return piece.getColor().equals(color);
    }
    //todo ? migrate to controller
    boolean canMoveThePiece(){
        if (occupied)
            return piece.canMove(this);
        else
            return false;
    }
    //todo ? migrate to controller
    boolean canArriveTo(Cell destination){
        return piece.canArrive(destination);
    }
    //todo ? migrate to controller

    Piece initialAdd(Piece piece) {
        addPiece(piece);
        updateView();
        return piece;
    }

    private boolean occupied;
    boolean isOccupied(){
        return occupied;
    }
    private void setOccupied(boolean arg){
        this.occupied = arg;
        view.setOccupied(arg);
    }

    /**
     * Moves Piece from one cell to current cell
     *
     * @param sourceCell cell's piece to move from
     * @return {@code true} if successful
     * {@code false} otherwise
     * @see #moveHere(Cell sourceCell)
     */
    boolean moveHere(Cell sourceCell) {
        //todo add description
        boolean isAddingSuccess = this.addPiece(sourceCell.piece);
        boolean isRemovingSuccess = sourceCell.removePiece();

        this.updateView();
        sourceCell.updateView();

        return isAddingSuccess && isRemovingSuccess;
    }
    /**
     * Adds Piece to current cell
     *
     * @param piece Object to add
     * @return {@code true} if successful
     * {@code false} otherwise
     * @see #moveHere(Cell sourceCell)
     */
    private boolean addPiece(Piece piece) {
        if (!occupied) { // ? overkill ? use assert
            this.piece = piece;
            setOccupied(true);
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
     * @see #moveHere(Cell sourceCell)
     */
    private boolean removePiece() {
        if (occupied) { // ? overkill ? use assert ?
            this.piece = null;
            setOccupied(false);
            return true;
        } else {
            return false;
        }
    }
    //STOPSHIP unique identifier of Cell , for pre alpha testing purposes only
    @Deprecated
    private int uId = 0; // "=0" is redundant AFAIK
    @Deprecated
    private static int count = 0;
    @Deprecated
    public int getUId() {
        return uId;
    }
    @Deprecated
    private void overflowWatchdog(){
        uId = uId + count;
        count++;
        assert this.uId < 64;
    }
}
