import java.util.*;

public class discountCalculator {
    double discount(DiscountInterface policy, double subtotal, List<OrderLine> lines) {
        return policy.value(subtotal, lines.size());
    }
}