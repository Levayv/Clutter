package am.levayv.testing.claio.chess.model.piece;

public enum ChessMan {

    // todo BUG , UNICODE icons are color specific !
    //   BUG , UNICODE not supported

    PAWN('P', 'p', (char) 0x2659, (char) 0x265F),
    KNIGHT('N', 'n', (char) 0x0000, (char) 0x0000),
    BISHOP('B', 'b', (char) 0x0000, (char) 0x0000),
    ROOK('R', 'r', (char) 0x0000, (char) 0x0000),
    QUEEN('Q', 'q', (char) 0x0000, (char) 0x0000),
    KING('K', 'k', (char) 0x0000, (char) 0x0000);

    private char letterWhite;
    private char letterBlack;
    private char iconWhite;
    private char iconBlack;

    ChessMan(char letterWhite, char letterBlack, char iconWhite , char iconBlack ) {
        this.letterWhite = letterWhite;
        this.letterBlack = letterBlack;
        this.iconWhite = iconWhite;
        this.iconBlack = iconBlack;
    }

    public char getIcon(boolean isWhite){
        return isWhite ? iconWhite : iconBlack;
    }
    public char getLetter(boolean isWhite){
        return isWhite ? letterWhite : letterBlack;
    }

}
