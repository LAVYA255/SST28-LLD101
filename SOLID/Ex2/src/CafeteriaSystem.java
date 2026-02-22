import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final Database store = new FileStore();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        invoiceGenerator gen = new invoiceGenerator();
        String invId = gen.genInvId(++invoiceSeq);
        gen.genhead(invId);
        gen.lineappend(lines, menu);

        double subtotal = new subtotalCalculator().subtotal(lines, menu);

        TaxInterface taxPolicy = TaxRules.forCustomer(customerType);
        double taxPct = taxPolicy.tax();
        double tax = new taxCalculator().tax(subtotal, taxPct);

        DiscountInterface discountPolicy = DiscountRules.forCustomer(customerType);
        double discount = new discountCalculator().discount(discountPolicy, subtotal, lines);
        double total = new totalCalculator().total(subtotal, tax, discount);

        gen.genbody(subtotal, taxPct, tax, discount, total);
        gen.footer(invId, store);
    }
}