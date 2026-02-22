public class TripleRoom implements RoomPricing {
    public boolean supports(int roomType) { return roomType == LegacyRoomTypes.TRIPLE; }
    public Money basePrice() { return new Money(12000.0); }
}