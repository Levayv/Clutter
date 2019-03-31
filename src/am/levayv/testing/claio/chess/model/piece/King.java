package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

// todo candidate cells not flashing after wrong click

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.KING;
    }

    /** ... Before each update cycle per piece , set and cellBuffer are purged ... */
    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - King move only 1 cell in any direction , total of 8 cells
        for (Navigator.Dir dir:
             Navigator.Dir.values()) {
            cellBuffer = Navigator.getNearbyCellTo(current, dir);
            if (cellBuffer!=null)
                this.baseMoveRule(cellBuffer);
        }
    }
}
