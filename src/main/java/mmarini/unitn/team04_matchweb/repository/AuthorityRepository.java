package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
