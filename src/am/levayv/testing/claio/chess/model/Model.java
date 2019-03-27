package am.levayv.testing.claio.chess.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Model { //aka root , AFAIK domain model , consider changing name to "ChessApi"
    private static final Logger log = LogManager.getLogger(Model.class);
    private static final Model instance = new Model(); //todo research lazy / eager loading

    private Model() {
        log.info("Init ...");
        board = new Board();
        controller = new Controller();
        log.info("Init OK");
    }

    public static Model getInstance() { return instance; }

    public Board board;
    public Controller controller;

    public static int getBoardSize() {
        return Board.getSize();
    }
}
