public interface Database {
    void save(String name, String content);
    int countLines(String name);
}