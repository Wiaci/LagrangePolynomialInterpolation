import java.util.ArrayList;
import java.util.List;

public class Interpolator {

    private final Problem problem;

    public Interpolator(Problem problem) {
        this.problem = problem;
    }

    public List<List<LagrangePolynomialPart>> calculateLagrangePolynomials() {
        List<List<LagrangePolynomialPart>> lagrangePolynomials = new ArrayList<List<LagrangePolynomialPart>>();
        for (int i = 0; i < problem.getPointSets().size(); i++) {
            List<LagrangePolynomialPart> lagrangePolynomial = new ArrayList<LagrangePolynomialPart>();
            List<Point> pointSet = problem.getPointSets().get(i);
            for (int j = 0; j < pointSet.size(); j++) {
                lagrangePolynomial.add(new LagrangePolynomialPart(pointSet, j));
            }
            lagrangePolynomials.add(lagrangePolynomial);
        }
        return lagrangePolynomials;
    }
}
