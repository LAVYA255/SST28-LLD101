public class DeluxeRoom implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.DELUXE; }
    public Money basePrice() { return new Money(16000.0); }
}