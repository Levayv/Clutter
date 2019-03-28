package am.levayv.testing.claio.chess.model.piece;

import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Navigator;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.PieceType;

import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    protected PieceType initType() {
        return PieceType.QUEEN;
    }

    @Override
    protected void updateAvailableMoves(Cell current , HashSet<Cell> set) {
        //todo IMF - Queen move unlmited cells in any direction , total of 8 directions max 27 !
        for (Navigator.Dir dir:
                Navigator.Dir.values()) {
            // reset cellBuffer reference to current Cell for each direction
            cellBuffer = current;
            // do maximum of 7 runs per direction
            System.out.println("!!! loop 1 "+dir.name());
            for (int i = 0; i < 7; i++) { //todo refactor Model.Board.getSize-1 , while vs for
                System.out.println("!!! loop 2 "+i);
                cellBuffer = Navigator.getNearbyCellTo(cellBuffer, dir);
                if (cellBuffer != null) {
                    System.out.println("!!! loop 2 cellBuffer not null");
                    boolean collision = baseMoveRule(cellBuffer);
                    if (collision) {
                        System.out.println("!!! loop 2 baseMove detects collision");
                        break;
                    }else {
                        System.out.println("!!! loop 2 baseMove empty");
                    }
                } else {
                    break; //todo refactor break >>> continue
                }
            }
        }
    }


}
