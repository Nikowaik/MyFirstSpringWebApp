package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LeagueController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private LeagueService leagueService;
    @GetMapping("leagues.html")
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

    public String saveLeague(@ModelAttribute("league") League league){
        leagueService.saveLeague(league);
        return "redirect/leagues.html";
    }
}
