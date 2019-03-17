package am.levayv.testing.claio.chess.model;

public class View {

    public char icon;
    public char letter;
    public View(char icon , char letter){
        this.icon = icon;
        this.letter = letter;
    }
    @Deprecated // todo reconsider deprecation ?
    public View(){
        icon = (char)0x2D; //todo change "0x2D" >> "0x20" ("-" >> " ")
        letter = (char)0x2D;
    }
    @Deprecated
    public String s;
}
