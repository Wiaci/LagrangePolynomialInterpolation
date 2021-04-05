import Functions.Function;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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
    private Set<Point> pointSet;

    public Plot(Function lagrangePolynomial, Function baseFunction,
                Set<Point> pointSet, String title) {
        this.lagrangePolynomial = lagrangePolynomial;
        this.baseFunction = baseFunction;
        this.pointSet = pointSet;
        setTitle(title);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (dimension.width / 2.5);
        int height = (int) (dimension.height / 2.5);
        setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);

        XYDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "X", "Y",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesStroke(2, new BasicStroke(0f));
        plot.setRenderer(renderer);

        setVisible(true);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries baseFunctionSeries = new XYSeries("sin(x)");
        XYSeries lagrangePolynomialSeries = new XYSeries("Poly");
        for (double i = -7; i < 7; i += 0.01) {
            double bfs = baseFunction.calculateAtPoint(i);
            double lps = lagrangePolynomial.calculateAtPoint(i);
            baseFunctionSeries.add(i, bfs);
            lagrangePolynomialSeries.add(i, lps);
        }
        dataset.addSeries(baseFunctionSeries);
        dataset.addSeries(lagrangePolynomialSeries);

        return dataset;
    }
}
