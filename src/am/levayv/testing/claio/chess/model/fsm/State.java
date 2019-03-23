package am.levayv.testing.claio.chess.model.fsm;

import am.levayv.testing.claio.chess.model.piece.data.Pos;

public interface State<E> {
    void update(E var);
    boolean onEvent(E var, Pos pos);
}
