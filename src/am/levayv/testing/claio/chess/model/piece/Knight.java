package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

//todo bug , clicking on self piece during candidate phase , not clearing candidate cells !
// find it ~ candidate update logic

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.KNIGHT;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - Knight move max 8 cells in L shaped jumps

        // todo WTF worst solution ever

        // north south
        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        // east west
        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.EAST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);
        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.NORTH);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

        cellBuffer = current;
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.WEST);
        if (cellBuffer!=null) cellBuffer = Navigator.getNearbyCellTo(cellBuffer, Navigator.Dir.SOUTH);
        if (cellBuffer!=null) this.baseMoveRule(cellBuffer);

    }


}
