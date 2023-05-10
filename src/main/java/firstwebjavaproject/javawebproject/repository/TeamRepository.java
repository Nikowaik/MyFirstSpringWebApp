package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    @Query("SELECT t FROM Team t WHERE t.league.id = :leagueId")
    List<Team> findTeamsByLeagueId(Long leagueId);
}
