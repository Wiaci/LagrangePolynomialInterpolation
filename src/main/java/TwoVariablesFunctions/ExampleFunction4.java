package TwoVariablesFunctions;

public class ExampleFunction4 implements TwoVariablesFunction {

    @Override
    public double calculateAt(double x, double y) {
        return (Math.log(x) + 1) / x / (y + 2);
    }
}
