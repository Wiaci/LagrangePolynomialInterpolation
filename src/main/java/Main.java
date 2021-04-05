import Functions.SinusFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(new SinusFunction(1, 0, 0));
        Interpolator interpolator = new Interpolator(problem);
        List<LagrangePolynomial> lagrangePolynomials = interpolator.calculateLagrangePolynomials();

        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < lagrangePolynomials.size(); i++) {
            Plot plot = new Plot(lagrangePolynomials.get(i), problem.getFunction(),
                    problem.getPointSets().get(i), "Набор данных " + (i + 1));
            plots.add(plot);
        }
    }
}
