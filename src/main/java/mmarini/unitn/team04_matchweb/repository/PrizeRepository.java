package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, Long> {

    @Query("SELECT p.description FROM Prize p WHERE p.username = :username")
    List<String> getPrizesByUsername(@Param("username") String username);
}
