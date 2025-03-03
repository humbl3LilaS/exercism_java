import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Gigasecond {
    private LocalDateTime moment;
    public Gigasecond(LocalDate moment) {
           this.moment = LocalDateTime.of(moment, LocalTime.MIDNIGHT).plusSeconds((long) Math.pow(10, 9));
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds((long) Math.pow(10, 9));
    }

    public LocalDateTime getDateTime() {
        return moment;
    }
}
