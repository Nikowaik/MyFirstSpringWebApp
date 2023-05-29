package firstwebjavaproject.javawebproject.dto;

public class TeamImportDTO {
    private Long id;
    private String name;
    private LeagueDTO league;

    public TeamImportDTO() {
        super();
    }

    public TeamImportDTO(Long id, String name, LeagueDTO league) {
        super();
        this.id = id;
        this.name = name;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public LeagueDTO getLeague() {
        return league;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeague(LeagueDTO league) {
        this.league = league;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
