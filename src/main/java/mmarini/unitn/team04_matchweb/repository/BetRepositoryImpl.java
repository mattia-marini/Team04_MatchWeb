package mmarini.unitn.team04_matchweb.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class BetRepositoryImpl implements BetRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Integer> getUserScoreByDay(String username, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();

        TypedQuery<Long> query = em.createQuery(
                "SELECT SUM(b.score) FROM Bet b WHERE b.username = :username AND b.playedAt >= :start AND b.playedAt < :end",
                Long.class
        );

        query.setParameter("username", username);
        query.setParameter("start", start);
        query.setParameter("end", end);

        Long sum = query.getSingleResult();
        return Optional.ofNullable(sum != null ? sum.intValue() : null);
    }
}
