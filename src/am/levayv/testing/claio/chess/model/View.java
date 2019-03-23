package am.levayv.testing.claio.chess.model;

import com.sun.istack.internal.NotNull;

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
    public void setEmpty(){
        icon = (char)0x2D;
        letter = (char)0x2D;
    }
    // UI markup ?
    private boolean isActive;
    private boolean isCandidate;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isCandidate() {
        return isCandidate;
    }

    public void setCandidate(boolean candidate) {
        isCandidate = candidate;
    }
}
