package LagrangeInterpolation;

import java.util.*;

public class InterpolationProblem {

    private final List<Point> pointSet;

    public InterpolationProblem(List<Point> pointSet) {
        this.pointSet = pointSet;
    }

    public List<Point> getPointSet() {
        return pointSet;
    }
}
