package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    void savePlayer(Player player);
    List<Player> getAllPlayersByTeam(Long teamId);
    Optional<Player> getPlayer(Long id);
    void deleteById(Long id);
}
