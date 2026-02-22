public class NoDiscount implements DiscountInterface {
    public double value(double subtotal, int distinctLines) {
        return 0.0;
    }
}