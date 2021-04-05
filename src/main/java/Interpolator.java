import java.util.ArrayList;
import java.util.List;

public class Interpolator {

    private final Problem problem;

    public Interpolator(Problem problem) {
        this.problem = problem;
    }

    public List<LagrangePolynomial> calculateLagrangePolynomials() {
        List<LagrangePolynomial> lagrangePolynomials = new ArrayList<>();
        for (int i = 0; i < problem.getPointSets().size(); i++) {
            LagrangePolynomial lagrangePolynomial = new LagrangePolynomial();
            List<Point> pointSet = problem.getPointSets().get(i);
            for (int j = 0; j < pointSet.size(); j++) {
                lagrangePolynomial.addPart(new LagrangePolynomialPart(pointSet, j));
            }
            lagrangePolynomials.add(lagrangePolynomial);
        }
        return lagrangePolynomials;
    }


}
