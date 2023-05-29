package firstwebjavaproject.javawebproject.services;


import firstwebjavaproject.javawebproject.model.Country;
import firstwebjavaproject.javawebproject.model.League;

import java.util.List;

public interface LeagueService {
    List<League> getAllLeagues();
    void saveLeague(League league);
    void deleteLeagueById(Long id);
    League getLeagueById(Long id);
    public League findByNameAndCountry(String name, Country country);
}
