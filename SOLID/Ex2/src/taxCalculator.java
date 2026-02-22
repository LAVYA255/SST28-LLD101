public class taxCalculator {
    double tax(double subtotal, double taxPct) {
        return subtotal * (taxPct / 100.0);
    }
}