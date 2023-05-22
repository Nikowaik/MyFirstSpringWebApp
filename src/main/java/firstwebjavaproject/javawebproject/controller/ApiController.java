package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.services.CountryService;
import firstwebjavaproject.javawebproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private CountryService  countryService;
    @Autowired
    private TeamService teamService;

    @GetMapping("/api/countries")
    public List<Country> getCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/api/teams")
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }
}
