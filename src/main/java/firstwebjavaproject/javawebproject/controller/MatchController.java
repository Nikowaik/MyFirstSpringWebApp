package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.services.LeagueService;
import firstwebjavaproject.javawebproject.services.MatchService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                            @ModelAttribute("match") Match match,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){


        League league = leagueService.getLeagueById(leagueId);
        match.setLeague(league);
        boolean checkIfBothTeamsScored = matchService.checkIfBothTeamsScored(match);

        matchService.saveMatch(match);

        if (checkIfBothTeamsScored) {
            Team homeTeam = teamService.getTeamById(match.getHomeTeam().getId());
            Team awayTeam = teamService.getTeamById(match.getAwayTeam().getId());

            int homeTeamGoals = match.getHomeTeamScore();
            int awayTeamGoals = match.getAwayTeamScore();

            teamService.updateStatus(homeTeam, awayTeam, homeTeamGoals, awayTeamGoals);
        }

        LocalDate today = LocalDate.now();
        String redirectUrl = "redirect:/matchesByDate?date=" + today.toString();
        return redirectUrl;
    }

    public List<Team> populateTeams(@RequestParam("leagueId") Long leagueId){
        return teamService.getTeamsById(leagueId);
    }

    @GetMapping("all_matches")
    public String getAllMatches(Model model){
        List<Match> matches = matchService.getAllMatches();
        model.addAttribute("matches",matches);
        return "all_matches";
    }

    @GetMapping("/matchesByDate")
    public String getMatchesByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   LocalDate date,Model model){
        List<Match> matches = matchService.getMatchesByDate(date);
        List<League> leagues = leagueService.getAllLeagues();

        Map<League, List<Match>> leagueMatchesMap = new HashMap<>();
        for (League league : leagues) {
            leagueMatchesMap.put(league,matches.stream()
                    .filter(match -> match.getLeague().getId().equals(league.getId()))
                    .collect(Collectors.toList()));

        }

        leagueMatchesMap.entrySet().removeIf(entry->entry.getValue().isEmpty());

        model.addAttribute("leagueMatchesMap", leagueMatchesMap);
        model.addAttribute("date", date);

        return "matchesByDate";
    }

    @PostMapping("/deleteMatch/{id}/{date}")
    public String deleteMatch(@PathVariable("id") Long id, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        matchService.deleteMatch(id);
        return "redirect:/matchesByDate?date=" + date;
    }

}

