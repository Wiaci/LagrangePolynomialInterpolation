import LagrangeInterpolation.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdamsMethodSolver {

    private final Problem problem;
    private final int order;
    private final double step;

    public AdamsMethodSolver(Problem problem, int order) {
        this.problem = problem;
        this.order = order;
        step = Math.pow(problem.getAccuracy() / 10, 1D / order);
    }

    private void addFirstPoints(List<Point> pointSet, double currentX) {
        Point initial = problem.getCauchyPoint();
        pointSet.add(initial);
        //currentX += step;
        Point first = getAnotherPoint(currentX, initial);
        if (order < 2) return;
        currentX += step;

        Point second = getAnotherPoint(currentX, initial, first);
        pointSet.add(second);
        if (order < 3) return;
        currentX += step;

        Point third = getAnotherPoint(currentX, initial, first, second);
        pointSet.add(third);
        if (order < 4) return;
        currentX += step;

        Point fourth = getAnotherPoint(currentX, initial, first, second, third);
        pointSet.add(fourth);
        if (order < 5) return;
        currentX += step;

        Point fifth = getAnotherPoint(currentX, initial, first, second, third, fourth);
        pointSet.add(fifth);
    }

    private Point getAnotherPoint(double currentX, Point... points) {
        switch (points.length) {
            case 1: return new Point(currentX,
                    points[0].getY() + step * problem.calculateFunctionAt(points[0]));
            case 2: return new Point(currentX,
                    points[1].getY() + step * (3 * problem.calculateFunctionAt(points[1]) / 2 -
                            problem.calculateFunctionAt(points[0]) / 2));
            case 3: return new Point(currentX,
                    points[2].getY() + step * (23 * problem.calculateFunctionAt(points[2]) / 12 -
                            4 * problem.calculateFunctionAt(points[1]) / 3 +
                            5 * problem.calculateFunctionAt(points[0]) / 12));
            case 4: return new Point(currentX,
                    points[3].getY() + step * (55 * problem.calculateFunctionAt(points[3]) / 24 -
                            59 * problem.calculateFunctionAt(points[2]) / 24 +
                            37 * problem.calculateFunctionAt(points[1]) / 24 -
                            3 * problem.calculateFunctionAt(points[0]) / 8));
            case 5:
            default: return new Point(currentX,
                    points[4].getY() + step * (1901 * problem.calculateFunctionAt(points[4]) / 720 -
                            1387 * problem.calculateFunctionAt(points[3]) / 360 +
                            109 * problem.calculateFunctionAt(points[2]) / 30 -
                            637 * problem.calculateFunctionAt(points[1]) / 360 +
                            251 * problem.calculateFunctionAt(points[0]) / 720));
        }
    }

    private Point getAnotherPoint(double currentX, List<Point> pointSet) {
        Point[] points = new Point[order];
        for (int i = 0; i < order; i++) {
            points[i] = pointSet.get(pointSet.size() - order + i);
        }
        return getAnotherPoint(currentX, points);
    }

    public List<Point> getPointSet() {
        List<Point> pointSet = new ArrayList<>();

        double currentX = problem.getInterval().left();
        addFirstPoints(pointSet, currentX);

        currentX += order * step;

        for (double x = currentX; x < problem.getInterval().right(); x += step) {
            pointSet.add(getAnotherPoint(x, pointSet));
        }

        return pointSet;
    }

}
