package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;

import java.time.LocalDate;
import java.util.List;

public interface MatchService {
    List<Team> getAllTeamsByLeagueId(long leagueId);
    Match saveMatch(Match match);
    List<Match> getAllMatches();
    List<Match> getMatchesByDate(LocalDate date);
}
