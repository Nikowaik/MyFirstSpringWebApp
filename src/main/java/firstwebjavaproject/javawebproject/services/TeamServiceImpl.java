package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Team> getTeamsById(Long leagueId) {
        return teamRepository.findTeamsByLeagueId(leagueId);
    }

    @Override
    public List<Team> getHomeTeamsById(Long leagueId) {
        return teamRepository.findTeamsByLeagueId(leagueId);
    }

    @Override
    public List<Team> getAwayTeamsById(Long leagueId) {
        return teamRepository.findTeamsByLeagueId(leagueId);
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
}
