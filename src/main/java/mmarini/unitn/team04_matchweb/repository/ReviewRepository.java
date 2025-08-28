package mmarini.unitn.team04_matchweb.repository;

import mmarini.unitn.team04_matchweb.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
