package TwoVariablesFunctions;

public class ExampleFunction2 implements TwoVariablesFunction {

    @Override
    public double calculateAt(double x, double y) {
        return 2 * x * y / (x*x + 4);
    }
}
