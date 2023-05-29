package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.dto.PlayerDTO;
import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.PlayerService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/createPlayer/{teamId}")
    public String createForm(@PathVariable("teamId") Long teamId, Model model){
        model.addAttribute("player",new Player());
        model.addAttribute("teams",teamService.getAllTeams());
        model.addAttribute("countries",countryService.getAllCountries());
        model.addAttribute("team", teamService.getTeamById(teamId));

        return "createPlayer.html";
    }


    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player){
        playerService.savePlayer(player);
        return "redirect:/team/" + player.getTeam().getId();
    }

    @GetMapping("/players/edit/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Player>> getPlayer(@PathVariable Long id){
        Optional<Player> player = playerService.getPlayer(id);
            return new ResponseEntity<>(player, HttpStatus.OK);

    }

    @RequestMapping(value = "/edit/{id}", consumes = "application/json;charset=UTF-8", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<?> saveEditedPlayer(@PathVariable Integer id, @Validated @RequestBody PlayerDTO playerDTO){
        Team team = teamService.getTeamById(playerDTO.getTeamId());
        Country country = countryService.getCountryById(playerDTO.getNationalityId());
        Player player = new Player();
        player.setId(id);
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setTeam(team);
        player.setNationality(country);


        playerService.savePlayer(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }


    @RequestMapping(path = "players/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/playerProfile/{id}")
    public String showPlayerProfile(@PathVariable("id") Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        return "playerProfile";
    }

}
