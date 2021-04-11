package LagrangeInterpolation;

import Functions.Function;
import Functions.SinusFunction;

import java.util.*;

public class InterpolationProblem {

    private Function function;
    private final List<List<Point>> pointSets;

    public InterpolationProblem(Function function) {
        this.function = function;
        pointSets = new ArrayList<>();
        List<Point> set1 = new ArrayList<>();
        set1.add(new Point(-2.33, function.calculateAtPoint(-2.33)));
        set1.add(new Point(-0.37, function.calculateAtPoint(-0.37)));
        set1.add(new Point(0.02, function.calculateAtPoint(0.02)));
        set1.add(new Point(3.0, function.calculateAtPoint(3.0)));

        List<Point> set2 = new ArrayList<>();
        set2.add(new Point(-2.9, function.calculateAtPoint(-2.9)));
        set2.add(new Point(-2.33, function.calculateAtPoint(-2.33)));
        set2.add(new Point(-1.35, function.calculateAtPoint(-1.35)));
        set2.add(new Point(-0.37, function.calculateAtPoint(-0.37)));
        set2.add(new Point(-0.17, function.calculateAtPoint(-0.17)));
        set2.add(new Point(0.02, function.calculateAtPoint(0.02)));
        set2.add(new Point(1.51, function.calculateAtPoint(1.51)));
        set2.add(new Point(2.45, function.calculateAtPoint(2.45)));
        set2.add(new Point(3.0, function.calculateAtPoint(3.0)));

        List<Point> set3 = new ArrayList<>();
        set3.add(new Point(-2.9, function.calculateAtPoint(-2.9)));
        set3.add(new Point(-2.33, function.calculateAtPoint(-2.33)));
        set3.add(new Point(-1.35, function.calculateAtPoint(-1.35) + 1.2));
        set3.add(new Point(-0.37, function.calculateAtPoint(-0.37)));
        set3.add(new Point(-0.17, function.calculateAtPoint(-0.17)));
        set3.add(new Point(0.02, function.calculateAtPoint(0.02)));
        set3.add(new Point(1.51, function.calculateAtPoint(1.51) - 0.5));
        set3.add(new Point(2.45, function.calculateAtPoint(2.45)));
        set3.add(new Point(3.0, function.calculateAtPoint(3.0)));

        List<Point> set4 = new ArrayList<>();
        set4.add(new Point(-5.8, function.calculateAtPoint(-5.8)));
        set4.add(new Point(-4.66, function.calculateAtPoint(-4.66)));
        set4.add(new Point(-2.70, function.calculateAtPoint(-2.70)));
        set4.add(new Point(-0.74, function.calculateAtPoint(-0.74)));
        set4.add(new Point(-0.34, function.calculateAtPoint(-0.34)));
        set4.add(new Point(0.04, function.calculateAtPoint(0.04)));
        set4.add(new Point(3.02, function.calculateAtPoint(3.02)));
        set4.add(new Point(4.9, function.calculateAtPoint(4.9)));
        set4.add(new Point(6.0, function.calculateAtPoint(6.0)));

        pointSets.add(set1);
        pointSets.add(set2);
        pointSets.add(set3);
        pointSets.add(set4);
    }

    public double calculateAtPoint(double x) {
        return function.calculateAtPoint(x);
    }

    public Function getFunction() {
        return function;
    }

    public List<List<Point>> getPointSets() {
        return pointSets;
    }
}
