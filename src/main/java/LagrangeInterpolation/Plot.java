package LagrangeInterpolation;

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

    private final LagrangePolynomial lagrangePolynomial;
    private final Borders borders;

    public Plot(LagrangePolynomial lagrangePolynomial, Borders borders, String title) {
        this.lagrangePolynomial = lagrangePolynomial;
        this.borders = borders;
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

        /*XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, true);*/

        setVisible(true);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries lagrangePolynomialSeries = new XYSeries("Poly");
        for (double i = borders.left(); i < borders.right(); i += 0.01) {
            double lps = lagrangePolynomial.calculateAtPoint(i);
            lagrangePolynomialSeries.add(i, lps);
        }
        dataset.addSeries(lagrangePolynomialSeries);

        return dataset;
    }
}
