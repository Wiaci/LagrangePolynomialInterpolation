package TwoVariablesFunctions;

public class ExampleFunction5 implements TwoVariablesFunction {

    @Override
    public double calculateAt(double x, double y) {
        return -Math.tan(y) * Math.tan(x) * Math.tan(x);
    }
}
