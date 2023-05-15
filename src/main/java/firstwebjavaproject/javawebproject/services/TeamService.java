package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    Team saveTeam(Team team);
    void deleteTeamById(Long id);
    List<Team> getTeamsById(Long leagueId);
    List<Team> getHomeTeamsById(Long leagueId);
    List<Team> getAwayTeamsById(Long leagueId);
    Team getTeamById(Long id);
    void updateStatus(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore);

}
