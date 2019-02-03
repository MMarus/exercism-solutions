import java.util.Optional;

public class Twofer {
    public static String twofer(String name) {
        Optional<String> n = Optional.ofNullable(name);
        return String.format("One for %s, one for me.", n.orElse("you"));
    }
}
