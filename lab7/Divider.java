package lab7;

public class Divider {
    public static double divide(double dividend, double divisor) {
        if ( divisor == 0.0 ) {
            throw new ArithmeticException();
        }
        return dividend/divisor;
    }
}
