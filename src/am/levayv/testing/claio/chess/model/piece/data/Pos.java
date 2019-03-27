package am.levayv.testing.claio.chess.model.piece.data;

import am.levayv.testing.claio.chess.model.Board;

public class Pos { //todo reconsider mutation , research needed?
    // Cells are finite (no more no less then 64) with only one "Pos" composite object
    public byte x;
    public byte y;

    public Pos(int x , int y){
        Board.inBoundsAssertion(x,y);
        this.x = (byte) x;
        this.y = (byte) y;
    }

    /** static */
    public static String toCellName(int x, int y){
        return toCellName((byte)x , (byte) y);
    }
    public static String toCellName(Pos pos){
        return toCellName(pos.x , pos.y);
    }
    private static String toCellName(byte x, byte y){
        // todo ? refactor to return new char[2]{xBuffer , yBuffer}
        Board.inBoundsAssertion(x,y);
        char xBuffer;
        char yBuffer;
        switch (x){
            case 0: xBuffer = 'a'; break;
            case 1: xBuffer = 'b'; break;
            case 2: xBuffer = 'c'; break;
            case 3: xBuffer = 'd'; break;
            case 4: xBuffer = 'e'; break;
            case 5: xBuffer = 'f'; break;
            case 6: xBuffer = 'g'; break;
            case 7: xBuffer = 'h'; break;
            // todo absolute if assertion is used
            default: xBuffer = '?'; break;
        }
        switch (y){
            case 0: yBuffer = '1'; break;
            case 1: yBuffer = '2'; break;
            case 2: yBuffer = '3'; break;
            case 3: yBuffer = '4'; break;
            case 4: yBuffer = '5'; break;
            case 5: yBuffer = '6'; break;
            case 6: yBuffer = '7'; break;
            case 7: yBuffer = '8'; break;
            // todo absolute if assertion is used
            default: yBuffer = '?'; break;
        }
        return String.valueOf(xBuffer) + "" + String.valueOf(yBuffer);
    }
}
