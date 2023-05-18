package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Player;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.PlayerService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/countries";
    }


}
