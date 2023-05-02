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
}
