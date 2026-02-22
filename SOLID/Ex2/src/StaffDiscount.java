public class StaffDiscount implements DiscountInterface {
    public double value(double subtotal, int distinctLines) {
        if (distinctLines >= 3) return 15.0;
        return 5.0;
    }
}