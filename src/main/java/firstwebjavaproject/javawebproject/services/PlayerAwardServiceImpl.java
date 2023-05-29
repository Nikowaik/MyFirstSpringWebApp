package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.PlayerAward;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.PlayerAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerAwardServiceImpl implements PlayerAwardService{
    @Autowired
    private PlayerAwardRepository playerAwardRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Override
    public void save(PlayerAward playerAward) {
        playerAwardRepository.save(playerAward);
    }

    @Override
    public List<PlayerAward> getPlayerAwardsByTeamId(Long teamId) {
        Team team = teamService.getTeamById(teamId);
        List<Player> players = playerService.getAllPlayersByTeam(teamId);
        List<PlayerAward> playerAwards = new ArrayList<>();
        for (Player player : players) {
            playerAwards.addAll(getPlayerAwardsByPlayerId(player.getId()));
        }
        return playerAwards;
    }

    @Override
    public List<PlayerAward> getPlayerAwardsByPlayerId(Integer playerId) {
        return playerAwardRepository.findByPlayerId(playerId);
    }
}
