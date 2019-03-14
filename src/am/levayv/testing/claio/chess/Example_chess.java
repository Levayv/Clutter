package am.levayv.testing.claio.chess;

import am.levayv.testing.claio.chess.core.AbstractApp;
import am.levayv.testing.claio.chess.core.swing.SwingApp;
import am.levayv.testing.claio.chess.core.text.TextApp;

public class Example_chess {
    // entry point
    public static void start(AppType type) {
        AbstractApp app1;
        AbstractApp app2;
        switch (type) {
            case TEXT:
                System.out.println("Core init with " + type.name());
                app1 = new TextApp(type);
                break;
            case SWING:
                System.out.println("Core init with " + type.name());
                app2 = new SwingApp(type);
                break;
            case JAVAFX:
                System.out.println("Core init with " + type.name());
                break;
            case LIBGDX:
                System.out.println("Core init with " + type.name());
                break;
            default:
                System.out.println("Core init failed");
                break;
        }
    }
}
