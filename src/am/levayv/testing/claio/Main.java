package am.levayv.testing.claio;

import am.levayv.testing.claio.chess.AppType;
import am.levayv.testing.claio.chess.Example_chess;
import am.levayv.testing.claio.exceptions.Example_Exception;
import am.levayv.testing.claio.oop.Example_Encapsulation;
import am.levayv.testing.claio.oop2.Example_oop2;


public class Main {

    public static void main(String[] args) {
//        Example_Encapsulation.start();
//        Example_Exception.start();
//        Example_oop2.start();
        Example_chess.start(AppType.SWING);
        Example_chess.start(AppType.TEXT);

    }
}
