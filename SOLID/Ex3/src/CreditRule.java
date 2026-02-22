import java.util.*;

public class CreditRule implements EligibilityRule {
    public boolean check(StudentProfile s, List<String> reasons) {
        if (s.earnedCredits < 20) {
            reasons.add("credits below 20");
            return true;
        }
        return false;
    }
}