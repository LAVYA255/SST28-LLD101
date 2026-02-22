public class DoubleRoom implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.DOUBLE; }
    public Money basePrice() { return new Money(15000.0); }
}