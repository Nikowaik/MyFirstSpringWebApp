package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.Match;
import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService{
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
}
