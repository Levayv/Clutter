package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.data.Pos;
import com.sun.istack.internal.NotNull;

import java.util.HashSet;

public class Navigator {
    private static final int size = Board.getSize();
    private static Cell innerCellBuffer;

    //    private static HashSet<Cell> cells = new HashSet<Cell>(); // logic bug
    @Deprecated
    public static HashSet<Cell> getCells(HashSet<Cell> cells){
//        cells.clear();
//        cells.add(Model.getInstance().board.getCell(new Pos(5,5)));
        return cells;
    }

    /**
     * @param cell reference to Board's composite cell
     * @param dir  nested static enum Cardinal Direction
     * @return cell reference from Board's corresponding cell
     *         null if out of Border's bounds
     * */
    public static synchronized Cell getNearbyCellTo(Cell cell, Dir dir){
        assert cell!=null;
//        System.out.println("!!! log Navigator cell is " + Pos.toCellName(cell.pos) + "...");
        innerCellBuffer = null;
        switch (dir){
            case NORTH:
                if (cell.pos.y+1<size){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x+0,
                                    cell.pos.y+1 );
                }break;
            case EAST:
                break;
            case SOUTH:
                if (cell.pos.y-1>=0){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x+0,
                                    cell.pos.y-1 );
                }break;
            case WEST:
                break;
            case NORTH_WEST:
                if (cell.pos.y+1<size && cell.pos.x-1>=0){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x-1,
                                    cell.pos.y+1 );
                }break;
            case NORTH_EAST:
                if (cell.pos.y+1<size && cell.pos.x+1<size){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x+1,
                                    cell.pos.y+1 );
                }break;
            case SOUTH_WEST:
                if (cell.pos.y-1>=0 && cell.pos.x-1>=0){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x-1,
                                    cell.pos.y-1 );
                }break;
            case SOUTH_EAST:
                if (cell.pos.y-1>=0 && cell.pos.x+1<size){
                    innerCellBuffer =
                            Model.getInstance().board.getCell(
                                    cell.pos.x+1,
                                    cell.pos.y-1 );
                }break;
        }
        return innerCellBuffer;
    }
    public static enum Dir{
        NORTH,
        EAST,
        SOUTH,
        WEST,
        NORTH_WEST,
        NORTH_EAST,
        SOUTH_WEST,
        SOUTH_EAST
    }
}
