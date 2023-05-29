package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.*;
import firstwebjavaproject.javawebproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private AwardService awardService;
    @Autowired
    private PlayerAwardService playerAwardService;

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
        List<Match> firstFiveMatches = matchService.getFirstFiveUpcomingMatches(teamId);
        List<Match> allUpcomingMatches = matchService.getAllUpcomingMatchesByTeamId(teamId);
        List<Team> teamsSorted = teamService.getAllTeamsSortedByPoints(team.getLeague().getId());
        List<Player> allPlayers = playerService.getAllPlayersByTeam(teamId);
        List<PlayerAward> allPlayersAward = playerAwardService.getPlayerAwardsByTeamId(teamId);

        System.out.println("First five upcoming matches: " + team);
        System.out.println("AllAwards: " + allPlayersAward);

        model.addAttribute("team", team);
        model.addAttribute("lastFiveMatches", lastFiveMatches);
        model.addAttribute("allPreviousMatches", allPreviousMatches);
        model.addAttribute("firstFiveMatches", firstFiveMatches);
        model.addAttribute("allUpcomingMatches", allUpcomingMatches);
        model.addAttribute("teams", teamsSorted);
        model.addAttribute("players", allPlayers);
        model.addAttribute("playerAwards", allPlayersAward);


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

    @GetMapping("/createAward/{teamId}")
    public String showCreateAwardForm(@PathVariable("teamId") Long teamId, Model model) {
        Team team = teamService.getTeamById(teamId);
        List<Player> players = playerService.getAllPlayersByTeam(teamId);

        model.addAttribute("team", team);
        model.addAttribute("players", players);
        model.addAttribute("award", new Award());

        return "createAward.html";
    }

    @PostMapping("/createAward/{teamId}")
    public String createAward(@PathVariable("teamId") Long teamId,@ModelAttribute("award") Award award) {
        // Create new Award entity and set name
        Award awardEntity = new Award();
        awardEntity.setName(award.getName());
        List<Player> players = playerService.getPlayersById(award.getPlayerIds());
        System.out.println("Players" + players);
        awardService.save(awardEntity);


        for (Player player : players) {
            PlayerAward playerAward = new PlayerAward();
            playerAward.setPlayer(player);
            playerAward.setAward(awardEntity);
            playerAward.setDate(LocalDate.now());



            playerAwardService.save(playerAward);
        }
        return "redirect:/team/" + teamId;
    }

}
