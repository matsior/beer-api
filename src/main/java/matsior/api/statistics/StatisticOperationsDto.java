package matsior.api.statistics;

import java.time.LocalDate;

public record StatisticDto(String styleName, LocalDate date, int count) { }
