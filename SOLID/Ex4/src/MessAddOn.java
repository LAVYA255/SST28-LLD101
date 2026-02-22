public class MessAddOn implements AddOnPricing {
    public boolean supports(AddOn addOn) { return addOn == AddOn.MESS; }
    public Money price() { return new Money(1000.0); }
}