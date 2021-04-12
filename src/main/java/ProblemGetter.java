import LagrangeInterpolation.Borders;
import LagrangeInterpolation.Point;
import TwoVariablesFunctions.*;

import java.util.Scanner;

public class ProblemGetter {

    public static Problem getProblem() throws IllegalInputException {
        Scanner in = new Scanner(System.in);
        TwoVariablesFunction function = getFunction(in);
        Point cauchyPoint = getCauchyPoint(in);
        double intervalEnd = getIntervalEnd(in);

        Borders interval = new Borders(cauchyPoint.getX(), intervalEnd);

        double accuracy = getAccuracy(in);
        return new Problem(function, cauchyPoint, interval, accuracy);
    }

    private static TwoVariablesFunction getFunction(Scanner in) throws IllegalInputException {
        System.out.println("Выберите уравнение:\n");
        System.out.println("1) y' - y(y-2) = 0");
        System.out.println("2) y' - 2xy/(x^2 + 4) = 0");
        System.out.println("3) y' + xe^y = 0");
        System.out.println("4) y' - (ln(x) + 1) / (x(y + 2)) = 0");
        System.out.println("5) y' + tg(y)/ctg^2(x) = 0");
        System.out.println("6) y' - y = 0");

        String answer = in.nextLine().trim();
        switch (answer) {
            case "1": return new ExampleFunction1();
            case "2": return new ExampleFunction2();
            case "3": return new ExampleFunction3();
            case "4": return new ExampleFunction4();
            case "5": return new ExampleFunction5();
            case "6": return new ExampleFunction6();
            default: throw new IllegalInputException();
        }
    }

    private static Point getCauchyPoint(Scanner in) throws IllegalInputException {
        System.out.println("Введите начальную точку в фомате: x0 y0");

        String[] answerParts = in.nextLine().trim().split(" ");
        if (answerParts.length != 2) throw new IllegalInputException();
        String isX = answerParts[0];
        String isY = answerParts[1];

        if (isDouble(isX) && isDouble(isY)) return new Point(
                Double.parseDouble(isX),
                Double.parseDouble(isY));

        throw new IllegalInputException();
    }

    private static double getIntervalEnd(Scanner in) throws IllegalInputException {
        System.out.println("Введите конец отрезка");

        String answer = in.nextLine().trim();
        if (isDouble(answer)) return Double.parseDouble(answer);
        throw new IllegalInputException();
    }

    private static double getAccuracy(Scanner in) throws IllegalInputException {
        System.out.println("Введите точность");

        String answer = in.nextLine().trim();
        if (isDouble(answer)) return Double.parseDouble(answer);
        throw new IllegalInputException();
    }

    private static boolean isDouble(String candidate) {
        return candidate.matches("^-?\\d+(.\\d+)?$");
    }

}
