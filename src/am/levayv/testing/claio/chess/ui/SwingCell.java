package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.CellView;

import javax.swing.JButton;

class SwingCell extends JButton{
    final CellView cellView;

    /** SwingCell is storing ONLY views of corresponding Cells*/
    SwingCell(CellView cellView) {
        this.cellView = cellView;
    }
}
