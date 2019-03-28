package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

import java.util.HashSet;

public abstract class Piece {
    private boolean isAlive;
    private PieceType type;
    private Color color;
    private HashSet<Cell> availableMoves;
    // todo cellBuffer write info comment
    protected Cell cellBuffer;
    /** Piece must NOT have a position , Piece assigned to cell, which had a position (refactor in progress)*/
    @Deprecated
    private Pos pos;
    //STOPSHIP unique identifier of piece , for pre alpha purposes only
    private int uId = 0; // "=0" is redundant AFAIK
    private static int count = 0; // "=0" is redundant AFAIK

    public Piece(Color color) {
        this.overflowWatchdog();
        this.color = color;
        this.type = initType();
        this.availableMoves = new HashSet<Cell>();
    }
    public boolean isAlive(){
        return isAlive;
    }
    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    protected abstract PieceType initType();
    //todo OUTDATED refactor view to cell

    public boolean canMove(){ //todo refactoring
        // todo bug and logic optimisation needed
        // 1. update available moves NOT on every piece selection
        //      on every piece movement CONSIDER AI & STATS classes

        //todo delete below row , it must be updated at switching players
//        updateAvailableMoves(currentCell, availableMoves);
        return !availableMoves.isEmpty();
    }
    public boolean canArrive(Cell destination){
        //todo clear available moves
        return availableMoves.contains(destination);
    }
    //todo optimise visibilty
    protected abstract void updateAvailableMoves(Cell current , HashSet<Cell> set);
    public void updateAvailableMoves(Cell current){
        updateAvailableMoves(current , this.availableMoves);
    }

    public HashSet<Cell> getAvailableMoves(){
        return this.availableMoves;
    }

    @Deprecated
    public Pos getPos() {
        return pos;
    }

    public boolean isWhite() { //todo reconsider refactoring
        return color.equals(Color.WHITE);
    }
    public Color getColor() { //todo reconsider refactoring (PLAYER >>> COLOR)
        return color;
    }

    public PieceType getType() {
        return type;
    }

    @Deprecated
    private void overflowWatchdog(){
        uId = uId + count;
        count++;
        assert this.uId <= 32;
    }

    @Deprecated
    public int getUId() {
        return uId;
    }

//    public View getView(){
//        return view;
//    }

    // todo reconsider ? bad practive ove one to one relation/binding of cell and piece
    private Cell occupyingCell;
    public Cell getOccupyingCell() {
        return occupyingCell;
    }
    public void setOccupyingCell(Cell occupyingCell) {
        this.occupyingCell = occupyingCell;
//        assert this.occupyingCell.getView().letter == this.getType().getLetter(this.isWhite());
        if (occupyingCell == null)
            assert this.occupyingCell == null;
        else{
            assert this.occupyingCell.getUId() == occupyingCell.getUId();
        }
    }
}
