package am.levayv.testing.claio.chess.core.swing;

import am.levayv.testing.claio.chess.AppType;
import am.levayv.testing.claio.chess.core.AbstractApp;
import am.levayv.testing.claio.chess.ui.SwingUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends AbstractApp implements ActionListener {
    private static final Logger log = LogManager.getLogger(SwingApp.class);

    private JFrame frame;
    private JPanel panelRoot;
    private JPanel panelMain; // consider main grid 8x8

    public SwingApp(AppType type) {
        // model init by parent
        super(type);
        windowInit();
        setUI();

//        /*todo delete*/ // view and controller instantiation
//        /*todo delete*/ this.view = new SwingView(panelMain,this);
//        /*todo delete*/ this.controller = new SwingController(this.model, this.view);

        // init Window

        // todo what's next man ?
//        view.update();
        //logger test
//        log.debug("This Will Be Printed On Debug");
//        log.info("This Will Be Printed On Info");
//        log.warn("This Will Be Printed On Warn");
//        log.error("This Will Be Printed On Error");
//        log.fatal("This Will Be Printed On Fatal");

    }

    @Override
    protected void setUI() {
        this.ui = new SwingUI(this, this.panelMain, this.model);
    }

    @Override
    protected void windowInit() {
        //Create and set up the window.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame("This will be Chess (Hopefully)");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.pack(); //useless ! bc frame is empty
                frame.setVisible(true);
                // todo BUG dimensions calculated before populating frame with squares and packing size
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                dim.width = dim.width / 2 - frame.getSize().width / 2;
                dim.height = dim.height / 2 - frame.getSize().height / 2;
                frame.setLocation(dim.width, dim.height);
                frame.add(panelRoot);
                frame.pack();
            }
        });
    }

//    @Override
//    public AbstractController setController(AbstractController controller) {
//        return null;
//    }
//
//    @Override
//    public AbstractView getView() {
//
//        return null;
//    }

    @Override
    public void actionPerformed(ActionEvent e) { //todo research, MouseClicked vs ActionPerformed
        // Forward all input to UI controller block
        ui.processInput(e);
    }
}
