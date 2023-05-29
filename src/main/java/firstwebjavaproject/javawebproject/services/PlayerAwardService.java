package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.PlayerAward;

import java.util.List;

public interface PlayerAwardService {
    void save(PlayerAward playerAward);
    List<PlayerAward> getPlayerAwardsByTeamId(Long teamId);
    List<PlayerAward> getPlayerAwardsByPlayerId(Integer playerId);
}
