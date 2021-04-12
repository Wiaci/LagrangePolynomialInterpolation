import LagrangeInterpolation.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Problem problem = ProblemGetter.getProblem();
            AdamsMethodSolver adamsMethodSolver = new AdamsMethodSolver(problem, 4);
            List<Point> pointListForInterpolation = adamsMethodSolver.getPointSet();
            InterpolationProblem interpolationProblem =
                    new InterpolationProblem(pointListForInterpolation);
            Interpolator interpolator = new Interpolator(interpolationProblem);
            LagrangePolynomial lagrangePolynomial = interpolator.calculateLagrangePolynomial();

            new Plot(lagrangePolynomial, problem.getInterval(), "Жирафик-график").setVisible(true);

        } catch (IllegalInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
