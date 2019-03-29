package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

public abstract class AbstractUI {

    protected final int size = Model.getBoardSize();
    protected Model model;
    public AbstractUI(Model model){
        this.model = model;
    } //todo useless arg if Model IS singleton
    public abstract void processInput(Pos pos);
    public abstract void update();

}
