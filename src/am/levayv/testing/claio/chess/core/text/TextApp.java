package am.levayv.testing.claio.chess.core.text;

import am.levayv.testing.claio.chess.AppType;
import am.levayv.testing.claio.chess.core.AbstractApp;
import am.levayv.testing.claio.chess.model.piece.Piece;
import am.levayv.testing.claio.chess.ui.TextUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextApp extends AbstractApp {
    private static final Logger log = LogManager.getLogger(TextApp.class);

    public TextApp(AppType type) {
        super(type);
        windowInit();
        setUI();
        log.info("TextApp : OK");
    }

    @Override
    protected void setUI() {
        this.ui = new TextUI();
    }

    @Override
    protected void windowInit() {
        //todo implement input by user
//        String qq;
//        Scanner scanner = new Scanner(System.in);
//        qq = scanner.nextLine();
//        System.out.println(qq);

        // todo refactor board must be PRIVATE , use MASKS only
        for (int i = 0; i < model.board.pieces.size(); i++) {
            Piece p = model.board.pieces.get(i);
//            System.out.println(p.getName().getLetter(p.isWhite())+
//                    " in pos = "+
//                    Pos.toCellName(p.getPos())+
//                    " id = "+p.getUId()
//            );
        }

    }



}
