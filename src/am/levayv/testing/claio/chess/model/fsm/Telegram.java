package am.levayv.testing.claio.chess.model.fsm;

public class Telegram {
    //todo refactor only pos ?
    private int msg;
    private String extraInfo;
    Telegram(int msg){
        this.msg = msg;
    }
    Telegram(int msg, String extraInfo){
        this.msg = msg;
        this.extraInfo = extraInfo;
    }

    public int getMsg() {
        return msg;
    }
}
