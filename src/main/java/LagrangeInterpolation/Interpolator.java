package LagrangeInterpolation;

import java.util.ArrayList;
import java.util.List;

public class Interpolator {

    private final InterpolationProblem problem;

    public Interpolator(InterpolationProblem problem) {
        this.problem = problem;
    }

    public LagrangePolynomial calculateLagrangePolynomial() {
        LagrangePolynomial lagrangePolynomial = new LagrangePolynomial();
        List<Point> pointSet = problem.getPointSet();
        for (int j = 0; j < pointSet.size(); j++) {
            lagrangePolynomial.addPart(new LagrangePolynomialPart(pointSet, j));
        }
        return lagrangePolynomial;
    }
}
