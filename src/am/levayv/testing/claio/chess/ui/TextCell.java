package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.CellView;

public class TextCell {
    public Cell cell;
    public CellView getView(){
        return cell.getView();
    }
}
