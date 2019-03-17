package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.View;

import javax.swing.*;

public class SwingCell extends JButton{

    // Store Model.Board.Cell each (64) reference
    public Cell cell; //todo temp
    public View getView(){
        return cell.getView();
    }
}
