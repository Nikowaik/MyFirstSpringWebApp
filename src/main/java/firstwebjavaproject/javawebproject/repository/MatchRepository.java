package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Match;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByDate(LocalDate date);
    @Query("SELECT m FROM Match m WHERE m.homeTeam.id = :teamId OR m.awayTeam.id = :teamId ORDER BY m.date DESC")
    List<Match> findTop5ByHomeTeamIdOrAwayTeamIdOrderByDateDesc(@Param("teamId") Long teamId, Pageable pageable);

    @Query("SELECT m FROM Match m WHERE m.homeTeam.id = :teamId OR m.awayTeam.id = :teamId ORDER BY m.date DESC")
    List<Match> findByHomeTeamIdOrAwayTeamIdOrderByDateDesc(@Param("teamId") Long teamId);
}
