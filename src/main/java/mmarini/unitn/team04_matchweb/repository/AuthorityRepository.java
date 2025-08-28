package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Authority a SET a.authority = :newRole WHERE a.username IN :usernames")
    int updateRolesForUsers(@Param("newRole") String newRole, @Param("usernames") List<String> usernames);
}
