package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Castling;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

// todo candidate cells not flashing after wrong click

public class King extends Piece {
    public Castling castling;
    public King(Color color) {
        super(color);
        if (color==Color.WHITE){
            castling = new Castling(
                    this,
                    Model.getInstance().board.getCell(1,0),
                    Model.getInstance().board.getCell(2,0),
                    Model.getInstance().board.getCell(3,0),
                    Model.getInstance().board.getCell(5,0),
                    Model.getInstance().board.getCell(6,0),
                    Model.getInstance().board.getCell(0,0),
                    Model.getInstance().board.getCell(7,0)
            );
        } else {
            castling = new Castling(
                    this,
                    Model.getInstance().board.getCell(1,7),
                    Model.getInstance().board.getCell(2,7),
                    Model.getInstance().board.getCell(3,7),
                    Model.getInstance().board.getCell(5,7),
                    Model.getInstance().board.getCell(6,7),
                    Model.getInstance().board.getCell(0,7),
                    Model.getInstance().board.getCell(7,7)
            );
        }

    }

    @Override
    protected PieceType initType() {
        return PieceType.KING;
    }

    /** ... Before each update cycle per piece , set and cellBuffer are purged ... */
    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - King move only 1 cell in any direction , total of 8 cells
        // Movement Logic - King
        for (Navigator.Dir dir:
             Navigator.Dir.values()) {
            cellBuffer = Navigator.getNearbyCellTo(current, dir);
            if (cellBuffer!=null)
                this.baseMoveRule(cellBuffer);
        }
        // Castling logic
        castling.update();
        if (castling.isAvailableLeft()){
            this.baseMoveRule(castling.getCellKingLeft());
        }
        if (castling.isAvailableRight()){
            this.baseMoveRule(castling.getCellKingRight());
        }
    }
    @Override
    public boolean isSpecialMove(Cell cellMoveDestination) {
        castling.left = (cellMoveDestination == castling.getCellKingLeft());
        castling.right = (cellMoveDestination == castling.getCellKingRight());
        System.out.println("Can do Castling : "
                +((castling.left)?"Left":"")+""
                +((castling.right)?"Right":"")
        );
        return castling.left || castling.right;
    }
    public boolean isCastlingToTheRight(){
        assert castling.left || castling.right;
        assert castling.left != castling.right;
        boolean rv = castling.right;
        castling.right = false;
        return rv;
    }

}
