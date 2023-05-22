package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.PlayerService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> saveEditedPlayer(@PathVariable Integer id, @Validated @RequestBody Player player){
        player.setId(id);
        playerService.savePlayer(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
