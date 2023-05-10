package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();
    Team saveTeam(Team team);
    void deleteTeamById(Long id);
}
