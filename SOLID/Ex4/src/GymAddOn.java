public class GymAddOn implements AddOnPricing {
    public boolean supports(AddOn addOn) { return addOn == AddOn.GYM; }
    public Money price() { return new Money(300.0); }
}