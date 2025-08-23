package mmarini.unitn.team04_matchweb.repository;

import java.time.LocalDate;
import java.util.Optional;

public interface BetRepositoryCustom {
    Optional<Integer> getUserScoreByDay(String username, LocalDate date);
}
