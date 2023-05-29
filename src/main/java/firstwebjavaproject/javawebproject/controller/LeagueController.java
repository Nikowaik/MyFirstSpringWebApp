package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.exception.DuplicateLeagueException;
import firstwebjavaproject.javawebproject.exception.LeagueNotEmptyException;
import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.TeamRepository;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.LeagueService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class LeagueController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private LeagueService leagueService;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamService teamService;

    @GetMapping("league.html")
    public String leagueView(Model model){
        model.addAttribute("listLeagues",leagueService.getAllLeagues());
        return("league");
    }

    @GetMapping("showNewLeagueForm")
    public String showNewLeagueForm(Model model){
        League league = new League();
        model.addAttribute("league",league);
        model.addAttribute("countries", countryService.getAllCountries());
        return "new_league";
    }

    @PostMapping("/saveLeague")
    public String saveLeague(@ModelAttribute("league") League league, Model model){
        try {
            leagueService.saveLeague(league);
            return "redirect:/league.html";
        } catch (DuplicateLeagueException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("league", league);
            model.addAttribute("countries", countryService.getAllCountries());
            return "new_league";
        }
    }



    @DeleteMapping("/deleteLeague/{id}")
    public ResponseEntity<?> deleteLeague(@PathVariable("id") Long id) {
        try {
            leagueService.deleteLeagueById(id);
            return ResponseEntity.ok().build();
        } catch (LeagueNotEmptyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
        }
    }
    @GetMapping("/editLeague/{id}")
    public String showEditLeagueForm(@PathVariable("id") Long id, Model model) {
        League league = leagueService.getLeagueById(id);
        List<Country> listCountries = countryService.getAllCountries();
        model.addAttribute("league", league);
        model.addAttribute("listCountries", listCountries);
        return "league";
    }

    @GetMapping("/league/{leagueId}/teams")
    public ModelAndView viewLeagueTeams(@PathVariable Long leagueId) {
        League league = leagueService.getLeagueById(leagueId);
        List<Team> teams = teamService.getAllTeamsSortedByPoints(leagueId);

        ModelAndView mav = new ModelAndView("league-teams.html");
        mav.addObject("league", league);
        mav.addObject("teams", teams);
        return mav;
    }

    @PostMapping("/updateLeague")
    public String updateLeague(@ModelAttribute("league") League league) {
        leagueService.saveLeague(league);
        return "redirect:/league.html";
    }
}
