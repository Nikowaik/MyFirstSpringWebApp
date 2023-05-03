package firstwebjavaproject.javawebproject.services;

import firstwebjavaproject.javawebproject.model.League;
import firstwebjavaproject.javawebproject.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public void deleteLeagueById(Long id) {
        leagueRepository.deleteById(id);
    }

    @Override
    public League getLeagueById(Long id) {
        Optional<League> league = leagueRepository.findById(id);
        if (league.isPresent()){
            return league.get();
        }
        else{
            throw new NoSuchElementException("League not found with id: " + id);
        }
    }

}
