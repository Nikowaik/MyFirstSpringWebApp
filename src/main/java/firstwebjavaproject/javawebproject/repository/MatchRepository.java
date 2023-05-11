package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
