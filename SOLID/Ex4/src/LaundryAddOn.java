public class LaundryAddOn implements AddOnPricing {
    public boolean supports(AddOn addOn) { return addOn == AddOn.LAUNDRY; }
    public Money price() { return new Money(500.0); }
}