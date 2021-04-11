import LagrangeInterpolation.Borders;
import LagrangeInterpolation.LagrangePolynomialPart;
import LagrangeInterpolation.Point;
import TwoVariablesFunctions.TwoVariablesFunction;

public class Problem {

    private final TwoVariablesFunction function;
    private final Point cauchyPoint;
    private final Borders interval;
    private final double accuracy;

    public Problem(TwoVariablesFunction function, Point cauchyPoint, Borders interval, double accuracy) {
        this.function = function;
        this.cauchyPoint = cauchyPoint;
        this.interval = interval;
        this.accuracy = accuracy;
    }

    public double calculateFunctionAt(Point point) {
        return function.calculateAt(point.getX(), point.getY());
    }

    public TwoVariablesFunction getFunction() {
        return function;
    }

    public Point getCauchyPoint() {
        return cauchyPoint;
    }

    public Borders getInterval() {
        return interval;
    }

    public double getAccuracy() {
        return accuracy;
    }
}
