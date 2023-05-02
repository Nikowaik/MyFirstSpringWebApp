package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService
{
    @Autowired
    private LeagueRepository leagueRepository;
    @Override
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @Override
    public void saveLeague(League league) {
        this.leagueRepository.save(league);
    }
}
