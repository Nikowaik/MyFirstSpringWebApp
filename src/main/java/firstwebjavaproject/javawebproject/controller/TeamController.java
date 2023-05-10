package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.services.LeagueService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private LeagueService leagueService;

    @GetMapping("teams.html")
   public String showAllTeam(Model model){
        List<Team> teams = teamService.getAllTeams();
        List<League> leagues = leagueService.getAllLeagues();
        model.addAttribute("teams", teams);
        model.addAttribute("leagues", leagues);
        model.addAttribute("newTeam", new Team());
        return "teams";
    }

    @PostMapping("teams")
    public String saveTeam(@ModelAttribute("newTeam") Team team) {
        teamService.saveTeam(team);
        return "redirect:/teams.html";
    }

    @GetMapping("/teams/new")
    public String showNewTeamForm(Model model){
        List<League> leagues = leagueService.getAllLeagues();
        model.addAttribute("team", new Team());
        model.addAttribute("leagues", leagues);
        return "new-team";
    }
//    @PostMapping("/teams")
//    public String addTeam(@ModelAttribute("team") @Validated Team team, BindingResult result) {
//        if (result.hasErrors()) {
//            return "new-team";
//        }
//        teamService.saveTeam(team);
//        return "redirect:/teams";
//    }

    @PostMapping("/teams/save")
    public String saveTeam(@Validated @ModelAttribute("team") Team team, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            List<League> leagues = leagueService.getAllLeagues();
            model.addAttribute("leagues", leagues);
            return "new-team";
        }

        teamService.saveTeam(team);
        return "redirect:/teams";
    }

    @PostMapping("/deleteTeam/{id}")
    public String deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
        return "redirect:/teams.html";
    }
}
