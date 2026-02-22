public class DiscountRules {
    public static DiscountInterface forCustomer(String customerType) {
        if ("student".equalsIgnoreCase(customerType)) return new StudentDiscount();
        if ("staff".equalsIgnoreCase(customerType)) return new StaffDiscount();
        return new NoDiscount();
    }

    public static double discountAmount(String customerType, double subtotal, int distinctLines) {
        return forCustomer(customerType).value(subtotal, distinctLines);
    }
}