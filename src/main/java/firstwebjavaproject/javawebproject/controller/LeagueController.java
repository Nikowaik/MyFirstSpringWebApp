package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LeagueController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private LeagueService leagueService;

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
    public String saveLeague(@ModelAttribute("league") League league){
        leagueService.saveLeague(league);
        return "redirect:/league.html";
    }

    @PostMapping("/deleteLeague/{id}")
    public String deleteLeague(@PathVariable("id") Long id) {
        leagueService.deleteLeagueById(id);
        return "redirect:/league.html";
    }
    @GetMapping("/editLeague/{id}")
    public String showEditLeagueForm(@PathVariable("id") Long id, Model model) {
        League league = leagueService.getLeagueById(id);
        List<Country> listCountries = countryService.getAllCountries();
        model.addAttribute("league", league);
        model.addAttribute("listCountries", listCountries);
        return "league";
    }

    @PostMapping("/updateLeague")
    public String updateLeague(@ModelAttribute("league") League league) {
        leagueService.saveLeague(league);
        return "redirect:/league.html";
    }

}
