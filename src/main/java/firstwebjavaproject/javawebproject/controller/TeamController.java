package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.services.LeagueService;
import firstwebjavaproject.javawebproject.services.MatchService;
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
    @Autowired
    private MatchService matchService;

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
    //navigate to teams.html
    @GetMapping("/team/{id}")
    public String showTeams(@PathVariable("id") Long teamId, Model model){
        Team team = teamService.getTeamById(teamId);
        List<Match> lastFiveMatches = matchService.getLastFiveMatches(teamId);
        List<Match> allPreviousMatches = matchService.getAllPreviousMatches(teamId);

        model.addAttribute("team", team);
        model.addAttribute("lastFiveMatches", lastFiveMatches);
        model.addAttribute("allPreviousMatches", allPreviousMatches);

        return "team";
    }

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
