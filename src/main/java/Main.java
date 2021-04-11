import Functions.SinusFunction;
import LagrangeInterpolation.Interpolator;
import LagrangeInterpolation.LagrangePolynomial;
import LagrangeInterpolation.Plot;
import LagrangeInterpolation.InterpolationProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterpolationProblem problem = new InterpolationProblem(new SinusFunction(1, 0, 0));
        Interpolator interpolator = new Interpolator(problem);
        List<LagrangePolynomial> lagrangePolynomials = interpolator.calculateLagrangePolynomials();

        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < lagrangePolynomials.size(); i++) {
            Plot plot = new Plot(lagrangePolynomials.get(i), problem.getFunction(),
                    problem.getPointSets().get(i), "Набор данных " + (i + 1));
            plots.add(plot);
        }

        System.out.println("Введите значение в формате: номер_набора точка");
        Scanner in = new Scanner(System.in);
        String answer;
        do {
            answer = in.nextLine().trim();
            String[] parts = answer.split(" ");
            if (parts.length == 2) {
                String isNum = parts[0];
                String isPoint = parts[1];
                if (isNum.matches("^[1-4]$") && isPoint.matches("^-?\\d+(.\\d+)?$")) {
                    int num = Integer.parseInt(isNum);
                    double point = Double.parseDouble(isPoint);
                    System.out.println("Значение полинома: " +
                            lagrangePolynomials.get(num - 1).calculateAtPoint(point));
                    System.out.println("Значение функции: " + problem.calculateAtPoint(point) + "\n");
                }
            }
        } while (!answer.equals("exit"));
    }
}
