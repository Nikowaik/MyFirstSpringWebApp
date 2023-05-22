package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayersByTeam(Long teamId) {
        return playerRepository.findPlayersByTeamId(teamId);
    }

    @Override
    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
