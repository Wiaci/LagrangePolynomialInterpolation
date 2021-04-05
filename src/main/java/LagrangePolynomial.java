import Functions.Function;

import java.util.ArrayList;
import java.util.List;

public class LagrangePolynomial implements Function {

    List<LagrangePolynomialPart> parts;

    public LagrangePolynomial() {
        parts = new ArrayList<>();
    }

    public void addPart(LagrangePolynomialPart part) {
        parts.add(part);
    }

    public double calculateAtPoint(double x) {
        double result = 0;
        for (LagrangePolynomialPart part : parts) {
            result += part.calculateAtPoint(x);
        }
        return result;
    }
}
