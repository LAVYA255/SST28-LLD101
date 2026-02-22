import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        HostelFeeCalculator calc = new HostelFeeCalculator(
            new FakeBookingRepo(),
            List.of(new SingleRoom(), new DoubleRoom(), new TripleRoom(), new DeluxeRoom()),
            List.of(new MessAddOn(), new LaundryAddOn(), new GymAddOn())
        );

        calc.process(req);
    }
}