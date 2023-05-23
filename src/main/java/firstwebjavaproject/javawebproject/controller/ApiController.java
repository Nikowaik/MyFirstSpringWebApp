package firstwebjavaproject.javawebproject.controller;

import firstwebjavaproject.javawebproject.dto.CountryDTO;
import firstwebjavaproject.javawebproject.dto.TeamDTO;
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
    public List<CountryDTO> getCountries(){
        return countryService.getAllCountriesAsDto();
    }

    @GetMapping("/api/teams")
    public List<TeamDTO> getTeams() {
        return teamService.getAllTeamsAsDto();
    }
}
