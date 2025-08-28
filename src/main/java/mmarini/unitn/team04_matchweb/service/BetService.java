package mmarini.unitn.team04_matchweb.service;

import mmarini.unitn.team04_matchweb.model.entity.Bet;
import mmarini.unitn.team04_matchweb.repository.BetRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BetService {

    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public int getTotalBets(String username) {
        return betRepository.getTotalBets(username);
    }

    public Optional<Long> getUserPointsByDate(String username, LocalDate date) {
        List<Object[]> results = betRepository.getUserPointsByDate(username, date);

        if (results.isEmpty()) {
            return Optional.empty();
        }

        // Only one result expected per user/date
        Object[] obj = results.get(0);
        return Optional.of(((Number) obj[1]).longValue());
    }


    public Map<String, Long> getTotalScorePerUserMap() {
        List<Object[]> results = betRepository.findTotalScorePerUser();

        return results.stream().collect(Collectors.toMap(obj -> (String) obj[0],          // username
                obj -> ((Number) obj[1]).longValue() // total score
        ));
    }

    public List<Pair<String, Long>> getRanking() {
        List<Object[]> results = betRepository.findTotalScorePerUser();
        return results.stream().map(obj -> Pair.of((String) obj[0], ((Number) obj[1]).longValue())).collect(Collectors.toList());
    }

    public Bet createBet(Bet bet) {
        return betRepository.save(bet);
    }

}
