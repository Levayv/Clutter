package am.levayv.testing.claio.chess.model;

public class View {
    // View must be pool ? when used with this constructor
    // alternative make static (default) icon letter ? when used with this constructor

    public char icon;
    public char letter;
//    public View(char icon , char letter){
//        this.icon = icon;
//        this.letter = letter;
//    }
    public View(){
        setEmpty();
    }

    //todo change "0x2D" >> "0x20" ("-" >> " ")
    void setEmpty(){
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

}
