package matsior.api.statistics;

import lombok.RequiredArgsConstructor;
import matsior.api.beer.BeerMapper;
import matsior.api.beer.BeerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
class StatisticsService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public Map<String, List<FinalResponse>> getStatistics() {

        List<StatisticOperationsDto> statisticOperationsDtos = beerRepository.findAll()
                .stream()
                .map(beer -> new StatisticOperationsDto(beer.getBeerStyle().getName(), LocalDate.ofInstant(beer.getDateAdded(), ZoneId.of("Europe/Warsaw"))))
                .toList();

        Map<String, List<LocalDate>> allStylesList = new HashMap<>();

        for (StatisticOperationsDto item : statisticOperationsDtos) {
            if (!allStylesList.containsKey(item.styleName())) {
                allStylesList.put(item.styleName(), new ArrayList<>());
                allStylesList.get(item.styleName()).add(item.date());
            } else {
                allStylesList.get(item.styleName()).add(item.date());
            }
        }

        System.out.println("------------");
        System.out.println(allStylesList);
        System.out.println("------------");

        Map<String, List<FinalResponse>> finalResult = new HashMap<>();

        for (String style : allStylesList.keySet()) {
            List<LocalDate> localDates = allStylesList.get(style);
            for (LocalDate localDate : localDates) {
                int frequency = Collections.frequency(localDates, localDate);
                System.out.println(frequency);
                if (!finalResult.containsKey(style)) {
                    finalResult.put(style, new ArrayList<>());
                    finalResult.get(style).add(new FinalResponse(localDate, frequency));
                } else {
                    List<FinalResponse> finalResponses = finalResult.get(style);
                    finalResponses.add(new FinalResponse(localDate, frequency));
                }

            }
        }
        return finalResult;
    }
}
