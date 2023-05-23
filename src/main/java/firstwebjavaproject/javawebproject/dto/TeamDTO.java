package firstwebjavaproject.javawebproject.dto;

import firstwebjavaproject.javawebproject.model.Team;
import firstwebjavaproject.javawebproject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public class TeamDTO {

    private TeamRepository teamRepository;

    private Long id;
    private String name;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
