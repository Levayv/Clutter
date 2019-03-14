package am.levayv.testing.claio.chess.core;

import am.levayv.testing.claio.chess.AppType;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.ui.AbstractUI;

import java.io.IOException;

public abstract class AbstractApp {
    private AppType type;
    protected Model model;
    protected AbstractUI ui;

    protected AbstractApp(AppType type) {
        this.type = type;
        model = Model.getInstance();
    }
    protected abstract void setUI();
    protected abstract void windowInit();

    //    public abstract AbstractController setController(AbstractController controller);

//    public abstract AbstractView getView();
}
