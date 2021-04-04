import java.util.ArrayList;
import java.util.List;

public class LagrangePolynomialPart {

    double multiplier;
    List<Double> particulars;

    public LagrangePolynomialPart(List<Point> pointSet, int num) {
        multiplier = pointSet.get(num).getY();
        particulars = new ArrayList<Double>();
        for (int j = 0; j < pointSet.size(); j++) {
            if (j == num) continue;
            multiplier /= pointSet.get(num).getX() - pointSet.get(j).getX();
            particulars.add(pointSet.get(j).getX());
        }
    }

    public double calculateAtPoint(double x) {
        double result = multiplier;
        for (Double particular : particulars) {
            multiplier *= x - particular;
        }
        return result;
    }
}
