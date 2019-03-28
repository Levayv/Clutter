package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.*;
import am.levayv.testing.claio.chess.model.piece.data.Color;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Board {
    /** Logger */
    private static final Logger log = LogManager.getLogger(Board.class);
    /** Board MUST be square (8x8 10x10), rectangular(8x10) shapes NOT supported */
    private final static int size = 8;
    /** Board MUST have cells equal to square root of size */
    private Cell[][] cell;

    @Deprecated //todo why pieces needed ? refactor or ...
    public ArrayList<Piece> pieces = new ArrayList<Piece>();


    Board() {
        log.info("Init ...");
        cell = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cell[i][j] = new Cell(i, j);
            }
        }
        log.info("Init OK");
    }

    public static int getSize() {
        return size;
    }

    /**
     * Returns Cell's reference from board's matrix
     *
     * @see #getCellFromMatrix(byte, byte)
     */
    public Cell getCell(int x, int y) {
        return getCellFromMatrix((byte) x, (byte) y);
    }

    /**
     * Returns Cell's reference from board's matrix
     *
     * @see #getCellFromMatrix(byte, byte)
     */
    public Cell getCell(Pos pos) {
        return getCellFromMatrix(pos.x, pos.y);
    }

    /**
     * Returns Cell's reference from board's matrix
     *
     * @param x ...
     * @param y ...
     * @return Cell ...
     */
    private Cell getCellFromMatrix(byte x, byte y) {
        inBoundsAssertion(x,y);
        return cell[x][y];
    }

    //todo refactor temp solution , research needed (save load stance)
    void setUpPieces() { // temp
        // pieces are instantiated >>> new Pawn(White), new King(Black)
        // Piece instance references are stored in both
        //      corresponding cell >>> cell[i][j].initialAdd(piece)
        //          initialAdd method returns argument reference for processing
        //      pieces list >>> pieces.add(piece)
        //          easy traversal for each piece on board
        // todo pieces not in play must be removed from arrays ?
        //
        pieces.add(cell[4][0].initialAdd(new King(Color.WHITE)));
        pieces.add(cell[4][7].initialAdd(new King(Color.BLACK)));
        pieces.add(cell[3][0].initialAdd(new Queen(Color.WHITE)));
        pieces.add(cell[3][7].initialAdd(new Queen(Color.BLACK)));
        pieces.add(cell[0][0].initialAdd(new Rook(Color.WHITE)));
        pieces.add(cell[7][0].initialAdd(new Rook(Color.WHITE)));
        pieces.add(cell[0][7].initialAdd(new Rook(Color.BLACK)));
        pieces.add(cell[7][7].initialAdd(new Rook(Color.BLACK)));
        pieces.add(cell[2][0].initialAdd(new Bishop(Color.WHITE)));
        pieces.add(cell[5][0].initialAdd(new Bishop(Color.WHITE)));
        pieces.add(cell[2][7].initialAdd(new Bishop(Color.BLACK)));
        pieces.add(cell[5][7].initialAdd(new Bishop(Color.BLACK)));
        pieces.add(cell[1][0].initialAdd(new Knight(Color.WHITE)));
        pieces.add(cell[6][0].initialAdd(new Knight(Color.WHITE)));
        pieces.add(cell[1][7].initialAdd(new Knight(Color.BLACK)));
        pieces.add(cell[6][7].initialAdd(new Knight(Color.BLACK)));
        pieces.add(cell[0][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[1][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[2][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[3][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[4][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[5][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[6][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[7][1].initialAdd(new Pawn(Color.WHITE)));
        pieces.add(cell[0][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[1][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[2][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[3][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[6][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[7][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[5][6].initialAdd(new Pawn(Color.BLACK)));
        pieces.add(cell[4][6].initialAdd(new Pawn(Color.BLACK)));
    }

    //STOPSHIP research if-else-if / exception / assert
    @Deprecated
    public static void inBoundsAssertion(byte x, byte y) {
        assert x >= 0;
        assert y >= 0;
        assert x < size;
        assert y < size;
    }

    @Deprecated
    public static void inBoundsAssertion(int x, int y) {
        assert x >= 0;
        assert y >= 0;
        assert x < size;
        assert y < size;
    }

    @Deprecated
    public static void inBoundsAssertion(Pos pos) {
        assert pos.x >= 0;
        assert pos.y >= 0;
        assert pos.x < size;
        assert pos.y < size;
    }
}