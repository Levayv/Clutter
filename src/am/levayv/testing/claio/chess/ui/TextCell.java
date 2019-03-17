package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.View;

public class TextCell {
    public Cell cell;
    public View getView(){
        return cell.getView();
    }
}
