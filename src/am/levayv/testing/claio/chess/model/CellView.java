package am.levayv.testing.claio.chess.model;

public class CellView {
    // CellView must be pool ? when used with this constructor
    // alternative make static (default) icon letter ? when used with this constructor

    public char icon;
    public char letter;
//    public CellView(char icon , char letter){
//        this.icon = icon;
//        this.letter = letter;
//    }
    CellView(){
        setEmpty();
    }

    void setEmpty(){
        // "0x2D" >> "0x20" ("-" >> " ")
        icon = (char)0x2D;
        letter = (char)0x2D;
    }

    // UI markup ?
    private CellStatus status = CellStatus.None;
    public CellStatus getStatus() {
        return status;
    }
    void setStatus(CellStatus status) {
        this.status = status;
    }

    private boolean isOccupied;
    public boolean isOccupied(){
        return isOccupied;
    }
    void setOccupied(boolean arg){
        this.isOccupied = arg;
    }

    private int WhiteOff;
    private int BlackOff;
    public int getWhiteOff() { return WhiteOff; }
    public void setWhiteOff(int whiteOff) { WhiteOff = whiteOff; }
    public int getBlackOff() { return BlackOff; }
    public void setBlackOff(int blackOff) { BlackOff = blackOff; }
}
