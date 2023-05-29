package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.PlayerAward;
import firstwebjavaproject.javawebproject.repository.PlayerAwardRepository;
import firstwebjavaproject.javawebproject.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerAwardRepository playerAwardRepository;
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
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if(optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            for ( PlayerAward playerAward: player.getPlayerAwards()) {
            playerAwardRepository.delete(playerAward);
            }
            playerRepository.deleteById(id);
        }
    }

    @Override
    public List<Player> getPlayersById(List<Integer> playerIds) {
      return playerRepository.findByIdIn(playerIds);
    }

    @Override
    public Player getPlayerById(Long id) {
      Optional<Player> player = playerRepository.findById(id);
      if (player.isPresent()){
          return player.get();
      }
      else{
          throw new RuntimeException("Player not found with id: " + id);
      }
    }
}
