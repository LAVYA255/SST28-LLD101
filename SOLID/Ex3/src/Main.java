import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityEngine engine = new EligibilityEngine(
            new FakeEligibilityStore(), List.of(
                new DisciplineRule(),
                new CgrRule(),
                new AttendanceRule(),
                new CreditRule()
            )
        );
        engine.runAndPrint(s);
    }
}