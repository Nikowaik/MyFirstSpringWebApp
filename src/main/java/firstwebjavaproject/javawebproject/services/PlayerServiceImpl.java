package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }
}
