package TwoVariablesFunctions;

public class ExampleFunction3 implements TwoVariablesFunction {

    @Override
    public double calculateAt(double x, double y) {
        return -x * Math.exp(y);
    }
}
