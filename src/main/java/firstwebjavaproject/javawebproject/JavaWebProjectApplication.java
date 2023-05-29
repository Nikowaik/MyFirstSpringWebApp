package firstwebjavaproject.javawebproject;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import firstwebjavaproject.javawebproject.dto.PlayerImportDTO;
import firstwebjavaproject.javawebproject.model.*;
import firstwebjavaproject.javawebproject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JavaWebProjectApplication {


    public static void main(String[] args) {
        SpringApplication.run(JavaWebProjectApplication.class, args);
    }


//    @Bean
//    CommandLineRunner runner(PlayerService playerService, TeamService teamService, LeagueService leagueService, CountryService countryService) {
//        return args -> {
//            ObjectMapper objectMapper = new ObjectMapper();
//
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/playerProfile.json");
//            try {
//                PlayerImportDTO playerDTO = objectMapper.readValue(inputStream, PlayerImportDTO.class);
//
//                Player player = new Player();
//                player.setFirstName(playerDTO.getFirstName());
//                player.setLastName(playerDTO.getLastName());
//                player.setAssists(playerDTO.getAssists());
//                player.setGoals(playerDTO.getGoals());
//
//                PlayerProfile playerProfile = new PlayerProfile();
//                playerProfile.setPosition(playerDTO.getPlayerProfile().getPosition());
//                playerProfile.setWeight(playerDTO.getPlayerProfile().getWeight());
//                playerProfile.setHeight(playerDTO.getPlayerProfile().getHeight());
//                playerProfile.setFoot(playerDTO.getPlayerProfile().getFoot());
//
//                Country nationality =  new Country();
//                nationality.setId(playerDTO.getNationality().getId());
//                nationality.setName(playerDTO.getNationality().getName());
//                countryService.saveCountry(nationality);
//
//                Country country = new Country();
//                country.setName(playerDTO.getTeam().getLeague().getCountry().getName());
//                country.setId(playerDTO.getTeam().getLeague().getCountry().getId());
//                countryService.saveCountry(country);
//
//                League league = new League();
//                league.setName(playerDTO.getTeam().getLeague().getName());
//                league.setId(playerDTO.getTeam().getLeague().getId());
//                league.setCountry(country);
//                leagueService.saveLeague(league);
//
//
//                Team team = new Team();
//                team.setName(playerDTO.getTeam().getName());
//                team.setId(playerDTO.getTeam().getId());
//                team.setLeague(league);
//                teamService.saveTeam(team);
//
//
//                player.setPlayerProfile(playerProfile);
//                player.setTeam(team);
//                player.setNationality(nationality);
//                team.setLeague(league);
//
//
//
//                playerService.savePlayer(player);
//
//
//                System.out.println("Players Saved!");
//
//            } catch (IOException e) {
//                System.out.println("Unable to save players: " + e.getMessage());
//            }
//        };
//    }
}

