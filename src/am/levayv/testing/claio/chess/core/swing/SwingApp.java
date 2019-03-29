package am.levayv.testing.claio.chess.core.swing;

import am.levayv.testing.claio.chess.AppType;
import am.levayv.testing.claio.chess.core.AbstractApp;
import am.levayv.testing.claio.chess.model.piece.data.Pos;
import am.levayv.testing.claio.chess.ui.SwingUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class SwingApp extends AbstractApp implements ActionListener{
    private static final Logger log = LogManager.getLogger(SwingApp.class);

    private JFrame frame;
    private JPanel panelRoot;
    private JPanel panelMain; // consider main grid 8x8
    private JPanel panelBot;

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
        this.ui = new SwingUI(this, this.panelMain);

//        // todo testing drag and drop
//
//        JTextField  compOne = new JTextField ();
//        JTextField  compTwo = new JTextField ();
//
//        panelBot.setLayout(new FlowLayout());
//
//        panelBot.add(compOne);
//        panelBot.add(compTwo);
//
//        compOne.setText("Text One");
//        compTwo.setText("Text Two");
//
//        compOne.setToolTipText("This is tooltip of Component 1");
//        compTwo.setToolTipText("This is tooltip of Component 2");
//
//        compOne.setDragEnabled(false);
//        compTwo.setDragEnabled(false);
//
//
////        compOne.setEnabled(false);
////        compTwo.setEnabled(false);

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
    @Override
    public void actionPerformed(ActionEvent event) { //todo research, MouseClicked vs ActionPerformed
        // Forward all input to UI controller block
        ui.processInput(getPosFromAwtEvent(event));
    }
    /** get Pos from Action event for passing to Controller */
    @Deprecated //MOUSE NOT WORKING AS INTENDED
    private static Pos getPosFromAwtEvent(AWTEvent awtEvent){
        // todo BUGGY refactor optimise
        assert awtEvent!= null;
        String command = null;
//        if (awtEvent instanceof MouseEvent){
//            assert ((MouseEvent) awtEvent).getSource() instanceof JButton;
//            command = ((JButton) ((MouseEvent) awtEvent).getSource()).getActionCommand();
//        }
        if (awtEvent instanceof ActionEvent){
            // Oracle: ActionEvent.getActionCommand(), null command string is legal, but not recommended.
            assert ((ActionEvent) awtEvent).getActionCommand() != null;
            command = ((ActionEvent) awtEvent).getActionCommand();
            // String s = ""; <<< this is legal string with 0 length
            assert !command.isEmpty();
        }
        assert command != null;
        //get coordinates from input
        int t = Integer.valueOf(command);
        // with consideration of coordinates must be less then 8
        int x = t / 10, y = t % 10;

        //todo refactor SMELL creating new object each time !
        // Pos is minimalistic object consistent of only 2 bytes
        return new Pos(x, y);
    }
}
