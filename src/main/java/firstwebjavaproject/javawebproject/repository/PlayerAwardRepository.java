package firstwebjavaproject.javawebproject.repository;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.PlayerAward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerAwardRepository extends JpaRepository<PlayerAward, Long> {
    List<PlayerAward> findByPlayerId(Integer playerId);
}
