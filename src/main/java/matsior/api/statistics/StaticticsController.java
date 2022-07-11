package matsior.api.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StaticticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/stats")
    public Map<String, List<FinalResponse>> test() {
        return statisticsService.getStatistics();
    }

}
