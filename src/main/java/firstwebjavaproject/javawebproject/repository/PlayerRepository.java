package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId")
    List<Player> findPlayersByTeamId(Long teamId);

    List<Player> findByIdIn(List<Integer> ids);
}
