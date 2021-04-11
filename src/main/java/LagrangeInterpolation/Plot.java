package LagrangeInterpolation;

import Functions.Function;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Set;

public class Plot extends JFrame {

    private Function lagrangePolynomial;
    private Function baseFunction;
    private List<Point> pointSet;

    public Plot(Function lagrangePolynomial, Function baseFunction,
                List<Point> pointSet, String title) {
        this.lagrangePolynomial = lagrangePolynomial;
        this.baseFunction = baseFunction;
        this.pointSet = pointSet;
        setTitle(title);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (dimension.width / 2.2);
        int height = (int) (dimension.height / 2.2);
        setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);

        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "X", "Y",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, true);

        setVisible(true);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries baseFunctionSeries = new XYSeries("sin(x)");
        XYSeries lagrangePolynomialSeries = new XYSeries("Poly");
        XYSeries interpolationPoints = new XYSeries("");
        for (double i = -7; i < 7; i += 0.01) {
            double bfs = baseFunction.calculateAtPoint(i);
            double lps = lagrangePolynomial.calculateAtPoint(i);
            baseFunctionSeries.add(i, bfs);
            lagrangePolynomialSeries.add(i, lps);
        }

        for (Point point : pointSet) {
            interpolationPoints.add(point.getX(), point.getY());
        }
        dataset.addSeries(baseFunctionSeries);
        dataset.addSeries(lagrangePolynomialSeries);
        dataset.addSeries(interpolationPoints);

        return dataset;
    }
}
