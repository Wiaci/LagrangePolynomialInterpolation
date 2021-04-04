package Functions;

public class SinusFunction implements Function {

    private final double a, b, c;

    public SinusFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateAtPoint(double x) {
        return a * Math.sin(x + b) + c;
    }
}
