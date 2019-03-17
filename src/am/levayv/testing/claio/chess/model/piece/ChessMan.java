package am.levayv.testing.claio.chess.model.piece;

public enum ChessMan {

    // todo (in Progress) BUG , UNICODE icons are color specific !
    // todo (in Progress) BUG , UNICODE not supported inside console

    PAWN('P', 'p', (char) 0x2659, (char) 0x265F),
    KNIGHT('N', 'n', (char) 0x0000, (char) 0x0000),
    BISHOP('B', 'b', (char) 0x0000, (char) 0x0000),
    ROOK('R', 'r', (char) 0x0000, (char) 0x0000),
    QUEEN('Q', 'q', (char) 0x2655, (char) 0x265B),
    KING('K', 'k', (char) 0x2654, (char) 0x265A);

    private char letterWhite;
    private char letterBlack;
    private char iconWhite;
    private char iconBlack;

    ChessMan(char letterWhite, char letterBlack, char iconWhite, char iconBlack) {
        this.letterWhite = letterWhite;
        this.letterBlack = letterBlack;
        this.iconWhite = iconWhite;
        this.iconBlack = iconBlack;
    }

    public char getIcon(boolean isWhite) {
        return isWhite ? iconWhite : iconBlack;
    }

    public char getLetter(boolean isWhite) {
        return isWhite ? letterWhite : letterBlack;
    }

}
