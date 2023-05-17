package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
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

    @Override
    public void updateStatus(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {

        validateTeamValues(homeTeam);
        validateTeamValues(awayTeam);

        validateTeamPoints(homeTeam, awayTeam, homeTeamScore, awayTeamScore);

        setGoalsScoredAndGoalsConcededForHomeAndAwayTeam(homeTeam, awayTeam, homeTeamScore, awayTeamScore);

        setGoalDifferenceAfterMatch(awayTeam);
        setGoalDifferenceAfterMatch(homeTeam);

        setMatchesPlayedForBothTeams(homeTeam);
        setMatchesPlayedForBothTeams(awayTeam);

        saveTeam(homeTeam);
        saveTeam(awayTeam);
    }

    @Override
    public List<Team> getAllTeamsSortedByPoints(Long leagueId) {
        List<Team> teams = teamRepository.findTeamsByLeagueId(leagueId);

        teams.sort(Comparator
                .comparing(Team::getPoints).reversed()
                .thenComparing(Team::getGoalDifference).reversed()
                .thenComparing(Team::getGoalsFor).reversed());

        return teams;
    }

    private void setMatchesPlayedForBothTeams(Team team) {
        team.setMatchesPlayed(team.getMatchesPlayed() + 1);

    }

    private void setGoalsScoredAndGoalsConcededForHomeAndAwayTeam(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
        homeTeam.setGoalsFor(homeTeam.getGoalsFor() + homeTeamScore);
        homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + awayTeamScore);

        awayTeam.setGoalsFor(awayTeam.getGoalsFor() + awayTeamScore);
        awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst() + homeTeamScore);
    }

    private void validateTeamPoints(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore > awayTeamScore) {
            homeTeam.setWins(homeTeam.getWins() + 1);
            awayTeam.setLosses(awayTeam.getLosses() + 1);
            homeTeam.setPoints(homeTeam.getPoints() + 3);
        } else if (homeTeamScore < awayTeamScore) {
            homeTeam.setLosses(homeTeam.getLosses() + 1);
            awayTeam.setWins(awayTeam.getWins() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 3);
        } else {
            homeTeam.setDraws(homeTeam.getDraws() + 1);
            awayTeam.setDraws(awayTeam.getDraws() + 1);

            homeTeam.setPoints(homeTeam.getPoints() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 1);
        }
    }

    private void setGoalDifferenceAfterMatch(Team team) {
        if (team.getMatchesPlayed() == null){
            team.setMatchesPlayed(0);
        }
        team.setGoalDifference(team.getGoalsFor() - team.getGoalsAgainst());
    }

    private void validateTeamValues(Team team) {
        if (team.getWins() == null) {
            team.setWins(0);
        }
        if (team.getLosses() == null) {
            team.setLosses(0);
        }
        if (team.getDraws() == null) {
            team.setDraws(0);
        }
        if (team.getGoalsFor() == null) {
            team.setGoalsFor(0);
        }
        if (team.getGoalsAgainst() == null) {
            team.setGoalsAgainst(0);
        }
        if (team.getPoints() == null) {
            team.setPoints(0);
        }
        if (team.getGoalDifference() == null) {
            team.setGoalDifference(0);
        }

    }
}
