import java.util.HashSet;
import java.util.Set;

public class PointSet {

    private final Set<Double> points;
    private final Borders borders;

    public PointSet(double ... point) {
        points = new HashSet<Double>();
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : point) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        borders = new Borders(min, max);
    }

    public void add(double x) {
        points.add(x);
    }
}
