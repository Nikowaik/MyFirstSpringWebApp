package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.LeagueService;
import firstwebjavaproject.javawebproject.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private LeagueService leagueService;

    @GetMapping("/")
    public String getMatchesByDate(Model model){
        List<League> leagues = leagueService.getAllLeagues();

        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("leagues", leagues);

        return "index";
    }
}
