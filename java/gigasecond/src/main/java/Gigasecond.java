package gigasecond.src.main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private static final long gigaSecond = 1_000_000_000L;
    private LocalDateTime birthDateTime;

    public Gigasecond(LocalDate birthDate) {
        this(birthDate.atStartOfDay());
    }

    public Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    public LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(gigaSecond);
    }

}
