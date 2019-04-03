package am.levayv.testing.claio.observer;

import java.util.ArrayList;
import java.util.List;

public class Example_Observer {
    public static void start(){
        System.out.println("Testing Observer Patterns");
        Subject sub = new Subject();
        // Client configures the number and type of Observers
        Observer observer = new Observer(sub);
        sub.changeSomething(1);
        sub.changeSomething(2);
    }


}
