package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.model.piece.data.Owner;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cell {
    private static final Logger log = LogManager.getLogger(Cell.class);

    // Cell status can be PASSIVE ACTIVE CANDIDATE
    private Status status = Status.None;
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // View
    private View view;


    //STOPSHIP unique identifier of piece , for pre alpha purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0;
    public int getUId() {
        return uId;
    }

    // Active cell = cell drag and dropped or first clicked
//    @Deprecated
//    private boolean isActive = false;
//    @Deprecated
//    public boolean isActive() {
//        return status.equals(Status.Active);
//    }
//    public void setActive(boolean active) {
//        isActive = active;
//        view.setActive(active); //todo ASAP active vs status +updateView
//    }

//    private HashSet<Cell> availableMoves = new HashSet<Cell>();

    public Pos pos;

    // IDIOT POSITIONS ARE NOT DEFINED WHEN CREATING THE GODDAMN CELL !
    Cell(int x , int y) {
        uId = uId + count;
        count++;

        this.pos = new Pos(x,y); // todo refactor position init
        initView(); //todo refactor

    }
    private void initView(){
        view = new View();

    }
    public View getView(){ return this.view; }
    public void updateView(){
        if (isOccupied()){
            view.icon = piece.getType().getIcon(piece.getOwner() == Owner.WHITE);
            view.letter = piece.getType().getLetter(piece.getOwner() == Owner.WHITE);
        } else {
            view.setEmpty();
        }
    }

    public boolean isMine(Owner owner){
        return piece.getOwner().equals(owner);
    }
    public Piece piece;
    public boolean canMoveThePiece(){
        if (occupied)
            return piece.canMove(this);
        else
            return false;
    }
    public boolean canArriveTo(Cell destination){
        return piece.canArrive(destination);
//        return availableMoves.contains(this);
    }

    Piece initialAdd(Piece piece) {
        addPiece(piece);
        updateView();
//        System.out.println("!!! init piece, view update test : " + uId + " " + view.icon + " " + view.letter);
        return piece;
    }

    private boolean occupied;
    public boolean isOccupied(){
        return occupied;
    }

//    public View getView() {
//        if (!occupied)
//            return new View();
//        else
//            return piece.getView();
//    }
    /**
     * Moves Piece from one cell to current cell
     *
     * @param sourceCell cell's piece to move from
     * @return {@code true} if successful
     * {@code false} otherwise
     * @see #moveHere(Cell sourceCell)
     */
    public boolean moveHere(Cell sourceCell) {
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
    private boolean addPiece(Piece piece) { //todo use assert ?
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
     * @see #moveHere(Cell sourceCell)
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
