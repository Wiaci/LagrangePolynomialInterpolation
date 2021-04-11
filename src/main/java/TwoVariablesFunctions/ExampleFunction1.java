package TwoVariablesFunctions;

public class ExampleFunction1 implements TwoVariablesFunction {

    @Override
    public double calculateAt(double x, double y) {
        return y * (y + 2);
    }
}
