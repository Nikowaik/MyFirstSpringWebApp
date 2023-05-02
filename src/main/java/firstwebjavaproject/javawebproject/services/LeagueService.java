package firstwebjavaproject.javawebproject.services;


import firstwebjavaproject.javawebproject.model.League;

import java.util.List;

public interface LeagueService {
    List<League> getAllLeagues();
    void saveLeague(League league);
}
