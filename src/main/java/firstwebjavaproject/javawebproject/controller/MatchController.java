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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MatchController {

    @Autowired
    private LeagueService leagueService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private MatchService matchService;

    @GetMapping("/matches.html")
    public String returnMatchView(Model model) {
        model.addAttribute("leagues", leagueService.getAllLeagues());
        return "matches";
    }

    @GetMapping("/addMatch/{leagueId}")
    public String showAddMatchForm(@PathVariable("leagueId") Long leagueId, Model model) {
        League league = leagueService.getLeagueById(leagueId);
        List<Team> homeTeams = teamService.getHomeTeamsById(leagueId);
        List<Team> awayTeams = teamService.getAwayTeamsById(leagueId);

        model.addAttribute("leagueId", leagueId);
        model.addAttribute("homeTeams", homeTeams);
        model.addAttribute("awayTeams", awayTeams);
            List<League> leagues = leagueService.getAllLeagues();

            model.addAttribute("leagues", leagues);
            model.addAttribute("match", new Match());
            return "addMatch";
    }
    @PostMapping("/saveMatch/{leagueId}")
    public String saveMatch(@PathVariable("leagueId") Long leagueId,
                            @ModelAttribute("match") Match match){

        League league = leagueService.getLeagueById(leagueId);
        match.setLeague(league);
        matchService.saveMatch(match);
        return "redirect:/matches";
    }

    public List<Team> populateTeams(@RequestParam("leagueId") Long leagueId){
        return teamService.getTeamsById(leagueId);
    }
}

