package firstwebjavaproject.javawebproject.dto;

import firstwebjavaproject.javawebproject.model.Player;

public class PlayerDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Long teamId;
    private Long nationalityId;

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.teamId = player.getTeamId();
        this.nationalityId = player.getNationalityId();

    }

    public PlayerDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Long getNationalityId() {
        return nationalityId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setNationalityId(Long nationalityId) {
        this.nationalityId = nationalityId;
    }
}
