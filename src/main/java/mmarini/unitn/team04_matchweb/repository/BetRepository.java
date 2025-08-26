package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>, BetRepositoryCustom {

    @Query(value = """
            SELECT COUNT(*)
            FROM BET
            WHERE username = :username
            """, nativeQuery = true)
    int getTotalBets(@Param("username") String username);

    @Query(value = """
            SELECT username, SUM(score) as total
            FROM BET
            WHERE CAST(played_at AS DATE) = :date
              AND username = :username
            GROUP BY username
            ORDER BY total DESC
            """, nativeQuery = true)
    List<Object[]> getUserPointsByDate(@Param("username") String username, @Param("date") LocalDate date);


    @Query("""
            SELECT b.username, SUM(b.score) as TOT_SCORE
            FROM Bet b
            GROUP BY b.username
            Order by TOT_SCORE DESC
            """)
    List<Object[]> findTotalScorePerUser();
}
