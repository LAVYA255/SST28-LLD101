import java.util.*;
public class OnboardingPrinter {
    public void printInput(String raw){
        System.out.println("Input:"+raw);
    }
    public void printErrors(List<String> errors ){
        System.out.println("Errors: Cannot register");
        for(String e:errors) System.out.println("-"+e);

    }
    public void printSuccess(StudentRecord rec, int totalCount) {
            System.out.println("OK: created student " + rec.id);
            System.out.println("Saved. Total students: " + totalCount);
            System.out.println("CONFIRMATION:");
            System.out.println(rec);
    }
}