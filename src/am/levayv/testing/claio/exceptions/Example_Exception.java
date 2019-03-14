package am.levayv.testing.claio.exceptions;

public class Example_Exception {
    ////////////////////////////////////////////////////////////////
    //  *** Exception branches
    //  Throwable
    //      Exception
    //          RuntimeException (DivByZero , ArrayIndex)
    //          MyCustomException (extends Throwable)
    //      Error
    //
    //  *** Exception (EX) LifeCycle
    //  EX created
    //      EX thrown
    //          EX handled
    //          EX passed (until handled)
    //              EX handled (runtime termination outputting stack trace)
    //
    //
    // throws Exception
    ////////////////////////////////////////////////////////////////
    public static void start(){


    }
}
