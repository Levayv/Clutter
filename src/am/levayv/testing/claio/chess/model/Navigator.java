package am.levayv.testing.claio.chess.model;

import am.levayv.testing.claio.chess.model.piece.data.Pos;

import java.util.HashSet;

public class Navigator {
    private static final int size = Board.getSize();
    private static Cell innerCellBuffer;

//    private static HashSet<Cell> cells = new HashSet<Cell>(); // logic bug
    @Deprecated
    public static HashSet<Cell> getCells(HashSet<Cell> cells){
        cells.clear();
//        System.out.println("!!! adding dummy cell 5 5");
        cells.add(Model.getInstance().board.getCell(new Pos(5,5)));
//        System.out.println("!!! checking dummy cell "+Pos.toCellName(5,5));
        return cells;
    }

    /**
     * @param cell reference to Board's composite cell
     * @param dir  nested static enum Cardinal Direction
     * @return cell reference from Board's corresponding cell
     *         null if out of Border's bounds
     * */
    public static synchronized Cell getNearbyCellTo(Cell cell, Dir dir){
        innerCellBuffer = null;
        switch (dir){
            case NORTH:
//                if (cell!=null)
//                    System.out.println("!!! ok");
//                else
//                    System.out.println("!!! null");
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
                                    cell.pos.x,
                                    cell.pos.y-1 );
                }break;
            case WEST:
                break;
            case NORTH_WEST:
                break;
            case NORTH_EAST:
                break;
            case SOUTH_WEST:
                break;
            case SOUTH_EAST:
                break;
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
