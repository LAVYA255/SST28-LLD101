import java.util.*;

public class OnboardingService {
    private final StudentRepository repo;
    private final StudentParser parser;
    private final Validator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository repo) {
        this.repo      = repo;
        this.parser    = new StudentParser();
        this.validator = new Validator();
        this.printer   = new OnboardingPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        List<String> errors = validator.validate(
            kv.getOrDefault("name", ""),
            kv.getOrDefault("email", ""),
            kv.getOrDefault("phone", ""),
            kv.getOrDefault("program", "")
        );

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(
            id,
            kv.get("name"), kv.get("email"), kv.get("phone"), kv.get("program")
        );

        repo.save(rec);
        printer.printSuccess(rec, repo.count());
    }
}