package matsior.api.statistics;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class DailyStatisticService {

    private static final ZoneId ZONE_ID = ZoneId.of("Europe/Warsaw");
    private static final Instant INSTANT = Instant.now();

    public static void main(String[] args) {
        getStatistics(INSTANT, ZONE_ID);
    }

    public static void getStatistics(Instant instant, ZoneId zoneId) {
        LocalDate localDate = LocalDate.ofInstant(instant, zoneId);
        System.out.println(localDate);

    }


}
