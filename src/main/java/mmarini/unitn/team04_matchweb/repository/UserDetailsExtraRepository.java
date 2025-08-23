package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.UserDetailsExtra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDetailsExtraRepository extends JpaRepository<UserDetailsExtra, Long> {
    Optional<UserDetailsExtra> getUserDetailsExtraByUsername(String username);

    List<UserDetailsExtra> findAllByOrderByUsernameAsc();
}
