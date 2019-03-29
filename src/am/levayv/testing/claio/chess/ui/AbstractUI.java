package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

public abstract class AbstractUI {

    protected Model model = Model.getInstance();
    protected final int size = Model.getBoardSize();
    public AbstractUI(){
    }
    public abstract void processInput(Pos pos);
    public abstract void update();

}
