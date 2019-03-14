package am.levayv.testing.claio.chess.core;

// refactor using one of collection framework (research needed)
public abstract class Matrix {
    private Object x; // change using generics ? (research needed)
    private Object y;
    private int size;
    private Object[][] core; // i smell VERY crappy solution

    Matrix(int size) {
        core = new Object[size][size];
    }

    public abstract void doSomething();
}
