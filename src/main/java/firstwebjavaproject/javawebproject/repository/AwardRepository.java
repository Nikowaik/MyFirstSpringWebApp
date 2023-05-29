package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long> {
}
