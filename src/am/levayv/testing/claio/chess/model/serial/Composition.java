package am.levayv.testing.claio.chess.model.serial;

import am.levayv.testing.claio.chess.model.Board;
import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Composition {

    private static int size = Board.getSize(); //temp

//    private Cell[][] cell;
    private static Cell[][] cell = new Cell[size][size];
    private List<Piece> pieces = new ArrayList<Piece>();

    public void generate(Board board) {
        size = Board.getSize();
        System.out.println("!!! generate()");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = board.getCell(i,j);
                if (cell[i][j].isOccupied()){
                    pieces.add(cell[i][j].getPiece());
                }
            }
        }
    }
    public void get(){
        System.out.println("!!! get()");

    }
}
