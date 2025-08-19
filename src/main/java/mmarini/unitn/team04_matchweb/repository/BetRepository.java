package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

    @Query(value = """
            SELECT COALESCE(SUM(score), 0)
            FROM BET
            WHERE username = :username
              AND CAST(played_at AS DATE) = CURRENT_DATE
            """, nativeQuery = true)
    int getPointsToday(@Param("username") String username);

    @Query(value = """
            SELECT COUNT(*)
            FROM BET
            WHERE username = :username
            """, nativeQuery = true)
    int getTotalBets(@Param("username") String username);

    @Query(value = """
            SELECT username, SUM(score) as total
            FROM BET
            WHERE CAST(played_at AS DATE) = CURRENT_DATE
            GROUP BY username
            ORDER BY total DESC
            """, nativeQuery = true)
    List<Object[]> getRankingToday();

    @Query(value = """
            SELECT username, SUM(score) as total
            FROM BET
            GROUP BY username
            ORDER BY total DESC
            """, nativeQuery = true)
    List<Object[]> getRanking();
}
