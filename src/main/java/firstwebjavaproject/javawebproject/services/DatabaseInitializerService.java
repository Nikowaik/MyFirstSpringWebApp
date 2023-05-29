package firstwebjavaproject.javawebproject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.PlayerProfile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class DatabaseInitializerService {
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public DatabaseInitializerService(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public void populateDatabase() {
        try{
            Resource resource = resourceLoader.getResource("classpath:playerProfile.json");
            InputStream inputStream = resource.getInputStream();
            Player[] players = objectMapper.readValue(inputStream, Player[].class);

            for (Player player : players) {
                PlayerProfile playerProfile = player.getPlayerProfile();
                entityManager.persist(playerProfile);
                player.setPlayerProfile(playerProfile);

                entityManager.persist(player);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
