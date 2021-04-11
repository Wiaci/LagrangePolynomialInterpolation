package LagrangeInterpolation;

public class Borders {

    private final double left, right;

    public Borders(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double left() {
        return left;
    }

    public double right() {
        return right;
    }
}
