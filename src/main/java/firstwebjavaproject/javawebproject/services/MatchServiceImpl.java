package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private TeamService teamService;
    @Autowired
    private MatchRepository matchRepository;


    @Override
    public List<Team> getAllTeamsByLeagueId(long leagueId) {
        return teamService.getTeamsById(leagueId);
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getMatchesByDate(LocalDate date) {
        return matchRepository.findByDate(date);
    }

    @Override
    public void deleteMatch(Long id) {
        this.matchRepository.deleteById(id);
    }

    @Override
    public List<Match> getLastFiveMatches(Long teamId) {
        Pageable pageable = PageRequest.of(0, 5);

        return matchRepository.findTop5ByHomeTeamIdOrAwayTeamIdOrderByDateDesc(teamId, pageable);
    }

    @Override
    public List<Match> getAllPreviousMatches(Long teamId) {
        return matchRepository.findByHomeTeamIdOrAwayTeamIdOrderByDateDesc(teamId);
    }

    @Override
    public boolean checkIfBothTeamsScored(Match match) {
        if (match.getHomeTeamScore() != null && match.getAwayTeamScore() != null) {
            match.setMatchState(Match.MatchState.Finished);
            return true;
        } else {
            match.setMatchState(Match.MatchState.ToBePlayed);
            return false;
        }
    }
}
