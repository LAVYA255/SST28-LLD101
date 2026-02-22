public class SingleRoom implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.SINGLE; }
    public Money basePrice() { return new Money(14000.0); }
}